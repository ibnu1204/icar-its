package id.its.icar.ui.screen.search

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.EmptyDestinationsNavigator
import id.its.icar.R
import id.its.icar.domain.route.model.response.Halte
import id.its.icar.ui.components.HalteComponent
import id.its.icar.ui.components.IcarTextField
import id.its.icar.ui.screen.destinations.HomeScreenDestination
import id.its.icar.ui.theme.Gray400
import id.its.icar.ui.theme.Gray500
import id.its.icar.utils.HalteName


/**
 * Created by wahid on 7/1/2024.
 * Github github.com/wahidabd.
 */


@Destination
@Composable
fun SearchScreen(navigator: DestinationsNavigator) {

    val searchValue by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_left),
                tint = Gray400,
                contentDescription = null,
                modifier = Modifier.clickable { navigator.popBackStack() }
            )

            IcarTextField(
                label = "",
                hint = "Search",
                value = searchValue,
                startIcon = R.drawable.ic_search,
                onValueChange = {}
            )
        }

        HorizontalDivider()

        LazyColumn(
            contentPadding = PaddingValues(vertical = 16.dp)
        ) {

            item {
                Text(
                    text = stringResource(id = R.string.select_shelter),
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp,
                    color = Gray500,
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                )
            }

            items(HalteName.entries.toTypedArray()) { data ->
                HalteComponent(
                    data = Halte(
                        id = "1",
                        name = "Halte ${data.halteName}",
                        distance = "100m",
                        time = "1m",
                    ),
                    onClick = {
                        navigator.navigate(
                            HomeScreenDestination(
                                halteName = data
                            )
                        ) {
                            popUpTo(HomeScreenDestination.route) {
                                inclusive = true
                            }
                        }
                    }
                )
            }
        }
    }
}

@Preview
@Composable
private fun SearchScreenPreview() {
    SearchScreen(navigator = EmptyDestinationsNavigator)
}