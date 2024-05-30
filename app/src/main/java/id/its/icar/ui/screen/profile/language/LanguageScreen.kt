package id.its.icar.ui.screen.profile.language

import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.os.LocaleListCompat
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.EmptyDestinationsNavigator
import id.its.icar.R
import id.its.icar.ui.components.IcarHeader
import id.its.icar.ui.theme.Typography


/**
 * Created by wahid on 5/30/2024.
 * Github github.com/wahidabd.
 */


@Destination
@Composable
fun LanguageScreen(navigator: DestinationsNavigator) {

    val context = LocalContext.current
    val deviceLocale = context.resources.configuration.locales.get(0)
    val currentLocale = remember { mutableStateOf(Languages.getCurrentLanguage(context)) }
    val appLocale: LocaleListCompat = LocaleListCompat.forLanguageTags("id")
    AppCompatDelegate.setApplicationLocales(appLocale)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        IcarHeader(
            title = R.string.change_language,
            onBackClick = { navigator.navigateUp() }
        )

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(Languages.allowedLocales) { language ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = stringResource(id = language.titleRes),
                        style = Typography.titleSmall,
                        fontSize = 14.sp,
                        color = Color.Black
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun LanguageScreenPreview() {
    LanguageScreen(EmptyDestinationsNavigator)
}