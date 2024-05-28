package id.its.icar.ui.screen.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import id.its.icar.R


/**
 * Created by wahid on 5/27/2024.
 * Github github.com/wahidabd.
 */


@Destination
@Composable
fun ProfileScreen(
    navigator: DestinationsNavigator
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.bg_main),
                contentScale = ContentScale.FillBounds
            )
            .padding(top = 24.dp)
    ) {
        Text(
            text = stringResource(id = R.string.label_profile),
            style = MaterialTheme.typography.bodyMedium.copy(
                color = Color.White,
                fontSize = 20.sp,
            ),
            modifier = Modifier
                .padding(horizontal = 16.dp)
        )
    }
}