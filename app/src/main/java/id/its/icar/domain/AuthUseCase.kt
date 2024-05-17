package id.its.icar.domain

import com.wahidabd.library.data.Resource
import com.wahidabd.library.utils.coroutine.handler.GenericResponse
import id.its.icar.domain.model.request.LoginRequest
import id.its.icar.domain.model.request.RegisterRequest
import id.its.icar.domain.model.response.LoginResponse
import kotlinx.coroutines.flow.Flow


/**
 * Created by wahid on 5/17/2024.
 * Github github.com/wahidabd.
 */


interface AuthUseCase {
    suspend fun login(body: LoginRequest): Flow<Resource<LoginResponse>>
    suspend fun register(body: RegisterRequest): Flow<Resource<GenericResponse>>
}