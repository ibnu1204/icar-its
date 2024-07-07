package id.its.icar.ui.screen.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wahidabd.library.data.Resource
import com.wahidabd.library.utils.coroutine.handler.GenericResponse
import id.its.icar.domain.user.AuthUseCase
import id.its.icar.domain.user.model.request.LoginRequest
import id.its.icar.domain.user.model.request.RegisterRequest
import id.its.icar.domain.user.model.response.LoginResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


/**
 * Created by wahid on 5/17/2024.
 * Github github.com/wahidabd.
 */


class AuthViewModel(
    private val useCase: AuthUseCase
) : ViewModel() {

    private val _login = MutableStateFlow<Resource<LoginResponse>>(Resource.loading())
    val login: StateFlow<Resource<LoginResponse>> get() = _login

    private val _register = MutableStateFlow<Resource<GenericResponse>>(Resource.loading())
    val register: StateFlow<Resource<GenericResponse>> get() = _register


    fun login(body: LoginRequest) {
        viewModelScope.launch {
            useCase.login(body).collectLatest {
                _login.value = it
            }
        }
    }

    fun register(body: RegisterRequest) {
        viewModelScope.launch {
            useCase.register(body).collectLatest {
                _register.value = it
            }
        }
    }
}