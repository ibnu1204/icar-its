package id.its.icar.ui.screen.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import id.its.icar.R
import id.its.icar.ui.components.IcarButton
import id.its.icar.ui.screen.destinations.LoginScreenDestination
import id.its.icar.ui.screen.destinations.RegisterScreenDestination
import id.its.icar.ui.theme.Primary200
import id.its.icar.utils.ButtonType


/**
 * Created by wahid on 5/9/2024.
 * Github github.com/wahidabd.
 */


@Destination
@Composable
fun OnBoardingScreen(navigator: DestinationsNavigator) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.bg_main),
                contentScale = ContentScale.FillBounds
            )
            .padding(top = 24.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 24.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold
                )
            )

            Spacer(modifier = Modifier.size(24.dp))

            Image(
                painter = painterResource(id = R.drawable.img_icar),
                contentDescription = "icar",
                modifier = Modifier
                    .background(Color.White.copy(alpha = 0.1f), shape = RoundedCornerShape(12.dp))
                    .border(1.dp, Color.White.copy(alpha = 0.8f), shape = RoundedCornerShape(12.dp))
                    .size(240.dp)
            )

            Spacer(modifier = Modifier.size(24.dp))

            Text(
                text = stringResource(id = R.string.label_onboarding_title),
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontSize = 24.sp,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold
                )
            )

            Spacer(modifier = Modifier.size(8.dp))

            Text(
                text = stringResource(id = R.string.label_onboarding_body),
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 16.sp,
                    color = Color.White,
                ),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.size(24.dp))

            IcarButton(
                text = stringResource(id = R.string.label_login_sso),
                icon = R.drawable.img_logo_blue,
                onClick = {}
            )

            Row(
                modifier = Modifier
                    .padding(vertical = 30.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                HorizontalDivider(modifier = Modifier.weight(1F), color = Primary200)
                Text(
                    text = stringResource(id = R.string.label_or),
                    color = Color.White,
                )
                HorizontalDivider(modifier = Modifier.weight(1F), color = Primary200)
            }

            IcarButton(
                text = stringResource(id = R.string.label_login),
                onClick = {
                    navigator.navigate(LoginScreenDestination)
                }
            )

            Spacer(modifier = Modifier.size(16.dp))

            IcarButton(
                text = stringResource(id = R.string.label_signup),
                type = ButtonType.TRANSPARENT,
                onClick = {
                    navigator.navigate(RegisterScreenDestination)
                }
            )
        }
    }
}