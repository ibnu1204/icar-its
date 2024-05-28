package id.its.icar.ui.components.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.only
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import id.its.icar.ui.theme.Gray600
import id.its.icar.ui.theme.Primary100
import id.its.icar.ui.theme.Primary600


/**
 * Created by wahid on 5/28/2024.
 * Github github.com/wahidabd.
 */


@Composable
fun BottomNavigationBar(
    navController: NavController,
    showBottomBar: Boolean = true,
    items: List<BottomNavItem> = listOf(
        BottomNavItem.Home,
        BottomNavItem.Ticket,
        BottomNavItem.Profile
    ),
    content: @Composable (paddingValues: PaddingValues) -> Unit
) {
    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                NavigationBar(
                    contentColor = Color.Transparent,
                    containerColor = Color.Transparent,
                ) {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentItem = navBackStackEntry?.destination

                    items.forEach { item ->
                        val selected = currentItem?.route == item.destination.route
                        val color = if (selected) Primary600 else Gray600

                        NavigationBarItem(
                            icon = {
                                Icon(
                                    painter = painterResource(id = item.icon),
                                    tint = color,
                                    contentDescription = stringResource(id = item.title),
                                )
                            },
                            label = {
                                Text(
                                    text = stringResource(id = item.title),
                                    style = MaterialTheme.typography.labelLarge,
                                    color = color,
                                )
                            },
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = Primary600,
                                selectedTextColor = Primary600,
                                indicatorColor = Primary100,
                                unselectedIconColor = color,
                                unselectedTextColor = color
                            ),
                            alwaysShowLabel = true,
                            selected = currentItem?.route?.contains(item.destination.route) == true,
                            onClick = {
                                navController.navigate(item.destination.route) {
                                    navController.graph.startDestinationRoute?.let { route ->
                                        popUpTo(route) {
                                            saveState = true
                                        }
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        )
                    }
                }
            }
        },
    ) { paddingValues ->
        content(paddingValues)
    }
}