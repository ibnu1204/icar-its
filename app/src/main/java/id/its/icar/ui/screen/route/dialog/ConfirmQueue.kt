package id.its.icar.ui.screen.route.dialog

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import id.its.icar.R
import id.its.icar.ui.theme.Gray50
import id.its.icar.ui.theme.Gray600
import id.its.icar.ui.theme.Gray900
import id.its.icar.ui.theme.Primary500
import id.its.icar.ui.theme.Primary600
import id.its.icar.utils.generateTimeNow


/**
 * Created by wahid on 7/7/2024.
 * Github github.com/wahidabd.
 */


@Composable
fun ConfirmQueue(
    modifier: Modifier = Modifier,
    route: String,
    halte: String,
    time: String,
    onDismiss: () -> Unit
) {
    Dialog(
        onDismissRequest = { onDismiss() },
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = false,
        ),
    ) {
        Surface(
            shape = RoundedCornerShape(24.dp),
            color = Color.White,
            contentColor = Color.White,
        ) {
            Column(
                modifier = modifier
                    .padding(24.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.label_confirm_queue),
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Medium,
                    fontSize = 24.sp,
                    color = Color.Black,
                )

                Row(
                    modifier = Modifier.padding(top = 12.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_bus_stop),
                        contentDescription = null,
                        tint = Primary600,
                        modifier = Modifier.size(16.dp)
                    )

                    Text(
                        text = halte,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp,
                        color = Gray900,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }

                HorizontalDivider(color = Gray50, modifier = Modifier.padding(vertical = 12.dp))

                Row {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_route),
                        contentDescription = null,
                        tint = Primary600,
                        modifier = Modifier.size(16.dp)
                    )

                    Text(
                        text = route,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp,
                        color = Gray900,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }

                HorizontalDivider(color = Gray50, modifier = Modifier.padding(vertical = 12.dp))

                Row {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_clock),
                        contentDescription = null,
                        tint = Primary600,
                        modifier = Modifier.size(16.dp)
                    )

                    Text(
                        text = time,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp,
                        color = Gray900,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }

                HorizontalDivider(color = Gray50, modifier = Modifier.padding(vertical = 12.dp))

                Row {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_calendar),
                        contentDescription = null,
                        tint = Primary600,
                        modifier = Modifier.size(16.dp)
                    )

                    Text(
                        text = "Hari ini (${generateTimeNow()})",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp,
                        color = Gray900,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }

                HorizontalDivider(color = Gray50, modifier = Modifier.padding(vertical = 12.dp))

                Row(
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(end = 22.dp, top = 12.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.label_cancek),
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp,
                        color = Gray600
                    )

                    Spacer(modifier = Modifier.padding(12.dp))

                    Text(
                        text = stringResource(id = R.string.label_queue_now),
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp,
                        color = Primary500
                    )
                }
            }
        }
    }
}