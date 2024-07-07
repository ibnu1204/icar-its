package id.its.icar.utils

import androidx.compose.ui.graphics.Color
import id.its.icar.ui.theme.Gray100
import id.its.icar.ui.theme.Gray700
import id.its.icar.ui.theme.Primary200
import id.its.icar.ui.theme.Primary500


/**
 * Created by wahid on 5/12/2024.
 * Github github.com/wahidabd.
 */


enum class ButtonType(
    val color: Color,
    val disable: Color,
) {
    WHITE(Color.White , Color.Gray),
    BLUE(Primary500, Primary200),
    BORDER(Color.Transparent, Color.Gray),
    TRANSPARENT(Color.Transparent, Color.Gray)
}