package id.its.icar.ui.components.navigation

import id.its.icar.R
import id.its.icar.ui.screen.destinations.Destination
import id.its.icar.ui.screen.destinations.HomeScreenDestination
import id.its.icar.ui.screen.destinations.ProfileScreenDestination
import id.its.icar.ui.screen.destinations.TicketScreenDestination


/**
 * Created by wahid on 5/28/2024.
 * Github github.com/wahidabd.
 */


sealed class BottomNavItem(
    val title: Int,
    val icon: Int,
    val destination: Destination
) {

    data object Home : BottomNavItem(
        title = R.string.label_home,
        icon = R.drawable.ic_home,
        destination = HomeScreenDestination
    )

    data object Ticket : BottomNavItem(
        title = R.string.label_my_ticket,
        icon = R.drawable.ic_ticket,
        destination = TicketScreenDestination
    )

    data object Profile : BottomNavItem(
        title = R.string.label_profile,
        icon = R.drawable.ic_profile,
        destination = ProfileScreenDestination
    )

}