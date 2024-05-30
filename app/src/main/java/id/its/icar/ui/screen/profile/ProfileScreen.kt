package id.its.icar.ui.screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.EmptyDestinationsNavigator
import id.its.icar.R
import id.its.icar.ui.screen.destinations.LanguageScreenDestination
import id.its.icar.ui.theme.Gray400
import id.its.icar.ui.theme.Gray50
import id.its.icar.ui.theme.Gray500
import id.its.icar.ui.theme.Gray900


/**
 * Created by wahid on 5/27/2024.
 * Github github.com/wahidabd.
 */


@Destination
@Composable
fun ProfileScreen(
    navigator: DestinationsNavigator
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.bg_main),
                contentScale = ContentScale.FillBounds
            )
            .padding(top = 24.dp)
    ) {
        Text(
            text = stringResource(id = R.string.label_profile),
            style = MaterialTheme.typography.bodyMedium.copy(
                color = Color.White,
                fontSize = 20.sp,
            ),
            modifier = Modifier
                .padding(horizontal = 16.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(1F)
                .padding(top = 16.dp)
                .background(
                    Color.White,
                    shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
                )
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(id = R.drawable.ic_placeholder_profile),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 24.dp)
                    .size(64.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Ahmad Ibnu Malik Rahman",
                style = MaterialTheme.typography.headlineMedium.copy(
                    color = Color.Black,
                    fontSize = 18.sp,
                    lineHeight = TextUnit.Unspecified
                )
            )

            Text(
                text = "5025201232@student.its.ac.id",
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Gray500,
                    fontSize = 14.sp,
                )
            )

            HorizontalDivider(
                color = Gray50,
                modifier = Modifier.padding(top = 20.dp, bottom = 12.dp)
            )

            MenuItem(icon = R.drawable.ic_edit, title = R.string.edit_profile) {}
            MenuItem(icon = R.drawable.ic_lock, title = R.string.change_password) {}
            MenuItem(icon = R.drawable.ic_language, title = R.string.change_language) {
                navigator.navigate(LanguageScreenDestination)
            }
            MenuItem(icon = R.drawable.ic_chat, title = R.string.call_center) {}
            MenuItem(icon = R.drawable.ic_logout, title = R.string.logout) {}
        }
    }
}

@Composable
fun MenuItem(
    modifier: Modifier = Modifier,
    icon: Int,
    title: Int,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier
            .clickable {
                onClick()
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier.size(22.dp)
            )

            Text(
                text = stringResource(id = title),
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Gray900,
                    fontSize = 14.sp,
                ),
                modifier = Modifier
                    .weight(1F)
                    .padding(horizontal = 8.dp)
            )

            Icon(
                painter = painterResource(id = R.drawable.ic_chevron_right),
                contentDescription = null,
                tint = Gray400
            )
        }

        HorizontalDivider(color = Gray50, modifier = Modifier.padding(start = 28.dp))
    }
}

@Preview
@Composable
private fun ProfileScreenPreview() {
    ProfileScreen(navigator = EmptyDestinationsNavigator)
}