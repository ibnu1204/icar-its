package id.its.icar.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.its.icar.ui.theme.Gray100
import id.its.icar.ui.theme.Gray700
import id.its.icar.ui.theme.Primary200
import id.its.icar.ui.theme.Primary500
import id.its.icar.utils.ButtonType


/**
 * Created by wahid on 5/12/2024.
 * Github github.com/wahidabd.
 */


@Composable
fun IcarButton(
    modifier: Modifier = Modifier,
    text: String,
    icon: Int = 0,
    type: ButtonType = ButtonType.WHITE,
    disable: Boolean = false,
    onClick: () -> Unit
) {
    Button(
        onClick = { if (!disable) onClick() },
        colors = ButtonDefaults.buttonColors(
            containerColor = if (!disable) type.color else type.disable,
        ),
        border = BorderStroke(
            width = 1.dp,
            color = when (type) {
                ButtonType.WHITE -> Primary200
                ButtonType.BLUE -> Color.Transparent
                ButtonType.BORDER -> Gray100
                ButtonType.TRANSPARENT -> Color.Transparent
            }
        ),
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
            .fillMaxWidth(),
        contentPadding = PaddingValues(0.dp)
    ) {
        if (icon != 0) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = "icon",
                modifier = modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.size(8.dp))
        }

        Text(
            text = text,
            style = MaterialTheme.typography.headlineSmall.copy(
                color = when (type) {
                    ButtonType.WHITE -> Primary500
                    ButtonType.BLUE -> Color.White
                    ButtonType.BORDER -> Gray700
                    ButtonType.TRANSPARENT -> Color.White
                },
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold
            )
        )
    }
}