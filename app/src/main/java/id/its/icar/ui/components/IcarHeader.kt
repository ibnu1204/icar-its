package id.its.icar.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.its.icar.R
import id.its.icar.ui.theme.Gray400
import id.its.icar.ui.theme.Gray50


/**
 * Created by wahid on 5/30/2024.
 * Github github.com/wahidabd.
 */


@Composable
fun IcarHeader(
    modifier: Modifier = Modifier,
    title: Int,
    onBackClick: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_arrow_left),
            contentDescription = null,
            tint = Gray400,
            modifier = Modifier
                .clickable { onBackClick() }
        )

        Text(
            text = stringResource(id = title),
            style = MaterialTheme.typography.headlineSmall.copy(
                fontSize = 16.sp,
                color = Color.Black,
                fontWeight = FontWeight.SemiBold
            ),
            modifier = Modifier
                .weight(1f)
                .padding(end = 24.dp),
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
private fun IcarHeaderPreview() {
    IcarHeader(
        title = R.string.change_language,
        onBackClick = {}
    )
}