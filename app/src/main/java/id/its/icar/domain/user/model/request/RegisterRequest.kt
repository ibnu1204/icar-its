package id.its.icar.domain.user.model.request

import com.google.firebase.firestore.Exclude


/**
 * Created by wahid on 5/17/2024.
 * Github github.com/wahidabd.
 */


data class RegisterRequest(
    val name: String,
    val email: String,
    val password: String
) {
    @Exclude
    fun toMap(): HashMap<String, Any?> {
        return hashMapOf(
            "name" to name,
            "email" to email
        )
    }
}
