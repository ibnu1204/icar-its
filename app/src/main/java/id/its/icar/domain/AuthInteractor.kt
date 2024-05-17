package id.its.icar.domain

import com.wahidabd.library.data.Resource
import com.wahidabd.library.utils.coroutine.handler.GenericResponse
import id.its.icar.data.AuthRepository
import id.its.icar.domain.model.request.LoginRequest
import id.its.icar.domain.model.request.RegisterRequest
import id.its.icar.domain.model.response.LoginResponse
import kotlinx.coroutines.flow.Flow


/**
 * Created by wahid on 5/17/2024.
 * Github github.com/wahidabd.
 */


class AuthInteractor(
    private val repository: AuthRepository
) : AuthUseCase {

    override suspend fun login(body: LoginRequest): Flow<Resource<LoginResponse>> {
        return repository.login(body)
    }

    override suspend fun register(body: RegisterRequest): Flow<Resource<GenericResponse>> {
        return repository.register(body)
    }
}