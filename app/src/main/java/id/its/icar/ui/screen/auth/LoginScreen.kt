package id.its.icar.ui.screen.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.wahidabd.library.utils.common.showToast
import com.wahidabd.library.utils.compose.collectStateFlow
import id.its.icar.R
import id.its.icar.domain.model.request.LoginRequest
import id.its.icar.ui.components.IcarButton
import id.its.icar.ui.components.IcarTextField
import id.its.icar.ui.screen.destinations.RegisterScreenDestination
import id.its.icar.ui.theme.Gray500
import id.its.icar.ui.theme.Gray600
import id.its.icar.ui.theme.Primary200
import id.its.icar.ui.theme.Primary500
import id.its.icar.utils.ButtonType
import org.koin.androidx.compose.koinViewModel
import timber.log.Timber


/**
 * Created by wahid on 5/9/2024.
 * Github github.com/wahidabd.
 */


@Destination
@Composable
fun LoginScreen(
    navigator: DestinationsNavigator,
    viewModel: AuthViewModel = koinViewModel()
) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.bg_main),
                contentScale = ContentScale.FillBounds
            )
            .padding(top = 24.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 24.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_left),
                contentDescription = "back",
                tint = Color.White,
                modifier = Modifier.clickable {
                    navigator.navigateUp()
                }
            )

            Spacer(modifier = Modifier.size(16.dp))

            Text(
                text = stringResource(id = R.string.label_login_account),
                style = MaterialTheme.typography.headlineMedium.copy(
                    color = Color.White,
                    fontSize = 20.sp,
                )
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(1F)
                .background(
                    Color.White,
                    shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
                )
                .padding(top = 32.dp)
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {

            IcarTextField(
                label = stringResource(id = R.string.label_email),
                hint = stringResource(id = R.string.label_hint_email),
                value = email,
                onValueChange = { email = it },
                type = KeyboardType.Email,
                modifier = Modifier
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.size(20.dp))

            IcarTextField(
                label = stringResource(id = R.string.label_password),
                hint = stringResource(id = R.string.label_hint_password),
                value = password,
                onValueChange = { password = it },
                type = KeyboardType.Password,
                showPassword = showPassword,
                transformPassword = { showPassword = it },
                modifier = Modifier
                    .fillMaxWidth()
            )

            Text(
                text = stringResource(id = R.string.label_forgot_password),
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Gray600,
                    fontSize = 12.sp
                ),
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(top = 6.dp)
            )

            Spacer(modifier = Modifier.size(32.dp))

            IcarButton(
                text = stringResource(id = R.string.label_login),
                type = ButtonType.BLUE,
                onClick = {
                    if (email.isNotEmpty() && password.isNotEmpty()) {
                        val body = LoginRequest(email, password)
                        viewModel.login(body)
                    } else {
                        showToast("Email or password cannot be empty")
                    }
                }
            )

            Row(
                modifier = Modifier
                    .padding(vertical = 12.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                HorizontalDivider(modifier = Modifier.weight(1F), color = Primary200)
                Text(
                    text = stringResource(id = R.string.label_or),
                    color = Gray500,
                )
                HorizontalDivider(modifier = Modifier.weight(1F), color = Primary200)
            }

            IcarButton(
                text = stringResource(id = R.string.label_login_sso),
                icon = R.drawable.img_logo_black,
                type = ButtonType.BORDER,
                onClick = {}
            )

            Spacer(modifier = Modifier.weight(1F))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(id = R.string.label_no_account),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = Gray600,
                        fontSize = 14.sp
                    )
                )

                Spacer(modifier = Modifier.size(4.dp))

                Text(
                    text = stringResource(id = R.string.label_signup),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = Primary500,
                        fontSize = 14.sp
                    ),
                    modifier = Modifier
                        .clickable {
                            navigator.navigate(RegisterScreenDestination)
                        }
                )

            }
        }
    }

    viewModel.login.collectStateFlow(
        onLoading = {},
        onFailure = { message ->
            showToast(message.toString())
            Timber.d(message.toString())
        },
        onSuccess = {
            Timber.d("$it")
        }
    )
}