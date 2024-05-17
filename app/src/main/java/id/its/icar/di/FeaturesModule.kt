package id.its.icar.di

import id.its.icar.data.AuthDataStore
import id.its.icar.data.AuthRepository
import id.its.icar.domain.AuthInteractor
import id.its.icar.domain.AuthUseCase
import id.its.icar.ui.screen.auth.AuthViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


/**
 * Created by wahid on 5/17/2024.
 * Github github.com/wahidabd.
 */


val authModule = module {
    single<AuthRepository> { AuthDataStore() }
    single<AuthUseCase> { AuthInteractor(get()) }
    viewModel { AuthViewModel(get()) }
}