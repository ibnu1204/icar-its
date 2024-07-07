package id.its.icar.ui.screen.route

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import id.its.icar.R
import id.its.icar.ui.components.IcarQueue
import id.its.icar.ui.components.IcarSnackbar
import id.its.icar.ui.screen.route.dialog.ConfirmQueue
import id.its.icar.ui.theme.Gray400
import id.its.icar.ui.theme.Gray50
import id.its.icar.ui.theme.Gray900
import id.its.icar.utils.HalteName
import id.its.icar.utils.RouteType
import id.its.icar.utils.getSchedule
import kotlinx.coroutines.launch


/**
 * Created by wahid on 7/7/2024.
 * Github github.com/wahidabd.
 */

@Destination
@Composable
fun RouteQueueScreen(
    route: RouteType,
    halte: HalteName,
    navigator: DestinationsNavigator
) {

    var openConfirmQueue by remember { mutableStateOf(false) }
    var selectedTime by remember { mutableStateOf("") }
    val snackState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .background(Color.White)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_left),
                    contentDescription = null,
                    tint = Gray400,
                    modifier = Modifier.size(24.dp)
                )

                Column(
                    modifier = Modifier
                        .padding(end = 24.dp)
                        .weight(1F),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    Text(
                        text = halte.halteName,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp,
                        color = Gray900
                    )

                    Text(
                        text = route.route,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp,
                        color = Gray400,
                    )
                }
            }

            HorizontalDivider(color = Gray50)

            val schedule = getSchedule(halte = halte, route = route)
            val times = ArrayList<String>()
            schedule.forEach { (_, _, _, time) ->
                time.map {
                    times.add(it.value)
                }
            }

            LazyColumn {
                items(times) { data ->
                    IcarQueue(
                        type = schedule[0].type,
                        time = data,
                        onClick = { isOpened ->
                            if (isOpened) {
                                selectedTime = data
                                openConfirmQueue = true
                            } else {
                                coroutineScope.launch {
                                    snackState.showSnackbar("Belum bisa antre. Silahkan memilih waktu lain yang tersedia.")
                                }
                            }
                        }
                    )
                }
            }
        }

        if (openConfirmQueue) {
            ConfirmQueue(
                route = route.route,
                halte = halte.halteName,
                time = selectedTime,
                onDismiss = { openConfirmQueue = false }
            )
        }

        SnackbarHost(
            hostState = snackState,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(bottom = 16.dp)
                .align(Alignment.BottomCenter)
        ) { snackbarData: SnackbarData ->
            IcarSnackbar(
                message = snackbarData.visuals.message
            )
        }
    }
}