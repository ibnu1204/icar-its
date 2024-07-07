package id.its.icar.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.its.icar.R
import id.its.icar.ui.theme.Gray300
import id.its.icar.ui.theme.Gray50
import id.its.icar.ui.theme.Gray500
import id.its.icar.ui.theme.Gray900
import id.its.icar.ui.theme.Success500
import id.its.icar.ui.theme.Warning50
import id.its.icar.ui.theme.Warning500
import id.its.icar.utils.checkBeforeTime


/**
 * Created by wahid on 7/7/2024.
 * Github github.com/wahidabd.
 */


@Composable
fun IcarQueue(
    modifier: Modifier = Modifier,
    type: String,
    time: String,
    onClick: (isOpen: Boolean) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .clickable { onClick(checkBeforeTime(time)) }
            .padding(horizontal = 16.dp)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 6.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Row(
                modifier = Modifier
                    .background(if (checkBeforeTime(time)) Warning50 else Gray50, shape = RoundedCornerShape(4.dp))
                    .padding(horizontal = 8.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_car),
                    contentDescription = null,
                    tint = if (checkBeforeTime(time)) Warning500 else Gray300,
                    modifier = Modifier
                        .size(14.dp)
                )

                Text(
                    text = type,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp,
                    color = if (checkBeforeTime(time)) Warning500 else Gray300,
                )
            }

            Text(
                text = "6 kursi",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = Gray500
            )
        }

        Text(
            text = time,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp,
            color = Gray900
        )

        Text(
            text = if (checkBeforeTime(time)) "0 orang dalam antrean" else "Antre 30 menit sebelum iCar tiba",
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            color = if (checkBeforeTime(time)) Success500 else Gray500
        )

        HorizontalDivider(color = Gray50, modifier = Modifier.padding(top = 16.dp))
    }
}