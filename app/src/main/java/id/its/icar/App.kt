package id.its.icar

import com.wahidabd.library.presentation.BaseApplication
import id.its.icar.di.authModule
import org.koin.core.module.Module
import timber.log.Timber


/**
 * Created by wahid on 5/12/2024.
 * Github github.com/wahidabd.
 */


class App : BaseApplication() {
    override fun getDefineModule(): List<Module> {
        return listOf(
            authModule
        )
    }

    override fun initApp() {
        Timber.plant(Timber.DebugTree())
    }
}