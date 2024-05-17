package id.its.icar.data

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.wahidabd.library.data.Resource
import com.wahidabd.library.utils.coroutine.handler.GenericResponse
import com.wahidabd.library.utils.firebase.FirebaseFirestoreManager
import id.its.icar.domain.model.request.LoginRequest
import id.its.icar.domain.model.request.RegisterRequest
import id.its.icar.domain.model.response.LoginResponse
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow


/**
 * Created by wahid on 5/17/2024.
 * Github github.com/wahidabd.
 */


class AuthDataStore : AuthRepository, FirebaseFirestoreManager() {

    override val databaseRef: FirebaseFirestore = FirebaseFirestore.getInstance()

    companion object {
        private val auth = FirebaseAuth.getInstance()
    }

    override suspend fun login(body: LoginRequest): Flow<Resource<LoginResponse>> = callbackFlow {
        trySend(Resource.loading())
        auth.signInWithEmailAndPassword(body.email, body.password)
            .addOnSuccessListener {
                getSingleValue(
                    id = body.email,
                    collection = "user",
                    clazz = LoginResponse::class.java,
                    eventListener = { trySend(it) },
                )
            }
            .addOnFailureListener {
                trySend(Resource.fail(it.message ?: "Error"))
            }

        awaitClose(this::close)
    }

    override suspend fun register(body: RegisterRequest): Flow<Resource<GenericResponse>> =
        callbackFlow {
            trySend(Resource.loading())
            auth.createUserWithEmailAndPassword(body.email, body.password)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        setValue(
                            id = body.email,
                            value = body.toMap(),
                            collection = "user",
                            eventListener = { data -> trySend(data) },
                        )
                    } else {
                        trySend(Resource.fail(it.exception?.message ?: "Error"))
                    }
                }
                .addOnFailureListener {
                    trySend(Resource.fail(it.message ?: "Error"))
                }

            awaitClose(this::close)
        }

}