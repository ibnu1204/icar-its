package id.its.icar.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wahidabd.library.utils.common.emptyString
import id.its.icar.ui.theme.Gray300
import id.its.icar.ui.theme.Gray50
import id.its.icar.ui.theme.Gray900


/**
 * Created by wahid on 6/17/2024.
 * Github github.com/wahidabd.
 */


@Composable
fun IcarIconButton(
    modifier: Modifier = Modifier,
    text: String = emptyString(),
    hint: String = emptyString(),
    @DrawableRes icon: Int,
    tint: Color = Color.Unspecified,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .border(width = 1.dp, shape = MaterialTheme.shapes.small, color = Gray50)
            .padding(horizontal = 16.dp, vertical = 12.dp)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = onClick
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = icon),
            tint = tint,
            contentDescription = null,
        )

        Spacer(modifier = Modifier.size(12.dp))

        Text(
            text = text.ifEmpty { hint },
            style = MaterialTheme.typography.titleMedium.copy(
                fontSize = 14.sp,
                color = if (text.isEmpty()) Gray300 else Gray900,
                fontWeight = FontWeight.Normal
            )
        )
    }
}

@Preview
@Composable
private fun IcarIconButtonPreview() {
    IcarIconButton(
        text = "Button",
        hint = "Button",
        icon = 0,
        onClick = {}
    )
}