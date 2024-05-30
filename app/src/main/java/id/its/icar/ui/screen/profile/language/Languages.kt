package id.its.icar.ui.screen.profile.language

import android.app.LocaleManager
import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.os.LocaleList
import androidx.appcompat.app.AppCompatDelegate
import id.its.icar.R
import java.util.Locale


/**
 * Created by wahid on 5/30/2024.
 * Github github.com/wahidabd.
 */


sealed class Languages {

    abstract val code: String
    abstract val titleRes: Int

    companion object {
        val allowedLocales = listOf(Indonesian, English)

        fun setLocale(context: Context, localCode: String) {
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.TIRAMISU) {
                context.getSystemService(LocaleManager::class.java).applicationLocales =
                    LocaleList.forLanguageTags(localCode)
            } else {
                saveToLocalSharedAndUpdateResources(context, localCode)
            }
        }

        internal fun getCurrentLanguage(context: Context): Languages {
            return this.allowedLocales.find { it.code == getCurrentLocale(context) } ?: English
        }

        private fun getCurrentLocale(context: Context): String {
            return if (Build.VERSION.SDK_INT > Build.VERSION_CODES.TIRAMISU) {
                context.getSystemService(LocaleManager::class.java).applicationLocales.toLanguageTags()
            } else {
                AppCompatDelegate.getApplicationLocales().toLanguageTags()
            }
        }

        // REQUIRED FOR API LEVEL 32 AND LOWER AND/OR FOR WITHOUT ACTIVITY RE-CREATION
        private const val sharedPrefSelectedLocaleKey = "LocalePreference"
        private fun getLocaleSharedPreference(context: Context): SharedPreferences? {
            return context.applicationContext?.getSharedPreferences(
                sharedPrefSelectedLocaleKey,
                Context.MODE_PRIVATE
            )
        }

        private fun setLocaleForDevicesLowerThanTiramisu(localeTag: String, context: Context) {
            val locale = Locale(localeTag)
            Locale.setDefault(locale)
            val resources = context.resources
            val configuration = resources.configuration
            configuration.setLocale(locale)
            resources.updateConfiguration(configuration, resources.displayMetrics)
        }

        private fun saveToLocalSharedAndUpdateResources(context: Context, localeTag: String) {
            val sharedPref = getLocaleSharedPreference(context) ?: return

            with(sharedPref.edit()) {
                putString(sharedPrefSelectedLocaleKey, localeTag)
                apply()
            }
            setLocaleForDevicesLowerThanTiramisu(localeTag, context)
        }

        //This needs to be called OnStart() or OnCreation() of the Activity for Android API level 32 and below
        fun configureLocaleOnStartForDevicesLowerThanTiramisu(context: Context) {
            setLocaleForDevicesLowerThanTiramisu(
                context = context,
                localeTag = getLocaleSharedPreference(context)?.getString(
                    sharedPrefSelectedLocaleKey,
                    English.code
                ) ?: English.code
            )
        }
    }

    object Indonesian : Languages() {
        override val code: String = "id"
        override val titleRes: Int = R.string.indonesian
    }

    object English : Languages() {
        override val code: String = "en"
        override val titleRes: Int = R.string.english
    }
}