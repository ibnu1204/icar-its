package id.its.icar.data.user

import com.wahidabd.library.data.Resource
import com.wahidabd.library.utils.coroutine.handler.GenericResponse
import id.its.icar.domain.user.model.request.LoginRequest
import id.its.icar.domain.user.model.request.RegisterRequest
import id.its.icar.domain.user.model.response.LoginResponse
import kotlinx.coroutines.flow.Flow


/**
 * Created by wahid on 5/17/2024.
 * Github github.com/wahidabd.
 */


interface AuthRepository {
    suspend fun login(body: LoginRequest): Flow<Resource<LoginResponse>>
    suspend fun register(body: RegisterRequest): Flow<Resource<GenericResponse>>
}