package id.its.icar.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.EmptyDestinationsNavigator
import id.its.icar.R
import id.its.icar.ui.components.IcarButton
import id.its.icar.ui.components.IcarIconButton
import id.its.icar.ui.screen.destinations.RouteQueueScreenDestination
import id.its.icar.ui.screen.destinations.SearchScreenDestination
import id.its.icar.ui.screen.home.dialog.SelectRouteBottomSheet
import id.its.icar.ui.theme.Gray50
import id.its.icar.ui.theme.Primary600
import id.its.icar.utils.ButtonType
import id.its.icar.utils.HalteName
import id.its.icar.utils.RouteType


/**
 * Created by wahid on 5/27/2024.
 * Github github.com/wahidabd.
 */


@RootNavGraph(start = true)
@Destination
@Composable
fun HomeScreen(
    halteName: HalteName? = null,
    navigator: DestinationsNavigator
) {

    var showRoute by remember { mutableStateOf(false) }
    var selectedHalte by remember { mutableStateOf(halteName) }
    var selectedRoute by remember { mutableStateOf<RouteType?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .paint(
                painter = painterResource(id = R.drawable.bg_header),
                contentScale = ContentScale.FillWidth,
                alignment = Alignment.TopCenter
            )
    ) {

        Spacer(modifier = Modifier.size(26.dp))

        Text(
            text = stringResource(id = R.string.queue_icar),
            style = MaterialTheme.typography.bodyMedium.copy(
                color = Color.White,
                fontSize = 20.sp,
            ),
            modifier = Modifier
                .padding(16.dp)
        )

        Spacer(modifier = Modifier.size(32.dp))

        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .background(color = Color.White, shape = RoundedCornerShape(12.dp))
                .border(width = 1.dp, color = Gray50, shape = RoundedCornerShape(12.dp))
        ) {
            IcarIconButton(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .padding(top = 12.dp),
                icon = R.drawable.ic_bus_stop,
                tint = Primary600,
                text = selectedHalte?.halteName ?: "",
                hint = stringResource(id = R.string.select_shelter),
                onClick = {
                    navigator.navigate(SearchScreenDestination)
                },
            )

            IcarIconButton(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .padding(top = 12.dp),
                icon = R.drawable.ic_route,
                tint = Primary600,
                text = selectedRoute?.route ?: "",
                hint = stringResource(id = R.string.select_route),
                onClick = {
                    showRoute = !showRoute
                },
            )

            IcarButton(
                modifier = Modifier
                    .padding(top = 12.dp, bottom = 16.dp)
                    .padding(horizontal = 16.dp),
                text = stringResource(id = R.string.queue_icar),
                type = ButtonType.BLUE,
                disable = selectedRoute == null || selectedHalte == null,
                onClick = {
                    navigator.navigate(RouteQueueScreenDestination(selectedRoute!!, selectedHalte!!))
                },
            )
        }
    }

    if (showRoute) {
        SelectRouteBottomSheet(
            onDismiss = { showRoute = false },
            onClick = { selectedRoute = it },
            defaultRoute = selectedRoute,
        )
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen(navigator = EmptyDestinationsNavigator)
}