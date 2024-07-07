package id.its.icar.ui.screen.home.dialog

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
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
import id.its.icar.R
import id.its.icar.ui.components.IcarButton
import id.its.icar.ui.theme.Gray100
import id.its.icar.ui.theme.Gray50
import id.its.icar.ui.theme.Gray700
import id.its.icar.ui.theme.Primary500
import id.its.icar.utils.ButtonType
import id.its.icar.utils.RouteType


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectRouteBottomSheet(
    modifier: Modifier = Modifier,
    defaultRoute: RouteType? = null,
    onClick: (RouteType) -> Unit,
    onDismiss: () -> Unit
) {

    val modalBottomSheet = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val selectedRoute = remember { mutableStateOf(defaultRoute) }

    ModalBottomSheet(
        onDismissRequest = { onDismiss() },
        sheetState = modalBottomSheet,
        containerColor = Color.White,
        tonalElevation = 8.dp,
        dragHandle = { BottomSheetDefaults.DragHandle() },
    ) {
        Column(
            modifier = modifier.padding(bottom = 34.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.select_shelter),
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                color = Gray700
            )

            Spacer(modifier = Modifier.size(16.dp))

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(RouteType.entries.toTypedArray()) { halte ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                            .selectable(
                                selected = selectedRoute.value == halte,
                                onClick = { selectedRoute.value = halte }
                            )
                            .border(
                                width = if (selectedRoute.value == halte) 2.dp else 1.dp,
                                color = if (selectedRoute.value == halte) Primary500 else Gray50,
                                shape = RoundedCornerShape(12.dp)
                            )
                            .padding(16.dp)
                    ) {
                        Text(
                            text = halte.route,
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Medium,
                            fontSize = 14.sp,
                            color = if (selectedRoute.value == halte) Primary500 else Gray700,
                            modifier = Modifier.weight(1F)
                        )

                        Icon(
                            painter = painterResource(id = if (selectedRoute.value == halte) R.drawable.ic_radio_button_enable else R.drawable.ic_radio_button_disable),
                            contentDescription = null,
                            tint = if (selectedRoute.value == halte) Primary500 else Gray100,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                IcarButton(
                    modifier = Modifier
                        .padding(top = 12.dp, bottom = 16.dp, start = 16.dp)
                        .weight(1F),
                    text = stringResource(id = R.string.label_cancek),
                    type = ButtonType.WHITE,
                    onClick = { onDismiss() },
                )

                Spacer(modifier = Modifier.size(12.dp))

                IcarButton(
                    modifier = Modifier
                        .padding(top = 12.dp, bottom = 16.dp, end = 16.dp)
                        .weight(1F),
                    text = stringResource(id = R.string.label_save),
                    type = ButtonType.BLUE,
                    onClick = {
                        selectedRoute.value?.let { onClick(it) }
                        onDismiss()
                    },
                )
            }
        }
    }
}


@Preview
@Composable
private fun SelectRouteBottomSheetPreview() {
    SelectRouteBottomSheet(
        onDismiss = {},
        onClick = {},
    )
}