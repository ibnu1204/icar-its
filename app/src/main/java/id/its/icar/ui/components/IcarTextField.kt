package id.its.icar.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.its.icar.ui.theme.Gray400
import id.its.icar.ui.theme.Gray50
import id.its.icar.ui.theme.Gray700


/**
 * Created by wahid on 5/12/2024.
 * Github github.com/wahidabd.
 */


@Composable
fun IcarTextField(
    modifier: Modifier = Modifier,
    label: String,
    hint: String,
    value: String,
    onValueChange: (String) -> Unit,
    fontSize: Int = 14,
    type: KeyboardType = KeyboardType.Text,
    showPassword: Boolean = false,
    transformPassword: ((Boolean) -> Unit)? = null
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelMedium,
            color = Gray700,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
        )

        Spacer(modifier = Modifier.padding(top = 6.dp))

        BasicTextField(
            value = value,
            onValueChange = { onValueChange(it) },
            textStyle = MaterialTheme.typography.bodyMedium.copy(
                fontSize = fontSize.sp,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = Gray50,
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(horizontal = 14.dp, vertical = 10.dp),
            keyboardOptions = KeyboardOptions(keyboardType = type),
            visualTransformation = if (!showPassword && type == KeyboardType.Password) PasswordVisualTransformation() else VisualTransformation.None,
            decorationBox = { innerTextField ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = if (value.isEmpty()) Arrangement.SpaceBetween else Arrangement.End
                ) {
                    if (value.isEmpty()) {
                        Text(
                            text = hint,
                            style = MaterialTheme.typography.bodyMedium.copy(color = Gray400, fontSize = fontSize.sp),
                            modifier = Modifier.weight(1F)
                        )
                    }

                    if (type == KeyboardType.Password) {
                        IconButton(
                            onClick = { transformPassword?.invoke(!showPassword) },
                            modifier = Modifier.size(22.dp)
                        ) {
                            Icon(
                                painter = painterResource(id = if (showPassword) id.its.icar.R.drawable.ic_eye_off else id.its.icar.R.drawable.ic_eye_open),
                                contentDescription = "Password",
                                tint = Gray400,
                            )
                        }
                    }
                }

                innerTextField.invoke()
            }
        )
    }
}