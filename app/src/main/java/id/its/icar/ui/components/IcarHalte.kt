package id.its.icar.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.its.icar.R
import id.its.icar.domain.route.model.response.Halte
import id.its.icar.ui.theme.Gray400
import id.its.icar.ui.theme.Gray50
import id.its.icar.ui.theme.Gray900


@Composable
fun HalteComponent(
    modifier: Modifier = Modifier,
    data: Halte,
    onClick: (Halte) -> Unit
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(top = 12.dp)
            .clickable {
                onClick(data)
            }
    ) {
        Text(
            text = data.name,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp,
            color = Gray900
        )

        Row(
            modifier = Modifier.padding(top = 2.dp)
        ) {
            Text(
                text = data.distance,
                style = MaterialTheme.typography.bodySmall,
                fontSize = 14.sp,
                color = Gray400
            )

            Text(
                text = "•",
                style = MaterialTheme.typography.bodySmall,
                fontSize = 14.sp,
                color = Gray400
            )

            Icon(
                painter = painterResource(id = R.drawable.ic_walk),
                contentDescription = null,
                tint = Gray400,
                modifier = Modifier.size(16.dp)
            )

            Text(
                text = data.distance,
                style = MaterialTheme.typography.bodySmall,
                fontSize = 14.sp,
                color = Gray400
            )
        }

        HorizontalDivider(color = Gray50, modifier = Modifier.padding(top = 12.dp))
    }
}