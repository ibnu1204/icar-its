package id.its.icar.ui.screen

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.rememberNavHostEngine
import id.its.icar.ui.components.navigation.BottomNavigationBar
import id.its.icar.ui.screen.destinations.HomeScreenDestination
import id.its.icar.ui.screen.destinations.ProfileScreenDestination
import id.its.icar.ui.screen.destinations.TicketScreenDestination
import id.its.icar.ui.screen.profile.language.Languages
import id.its.icar.ui.theme.IcarTheme

@OptIn(ExperimentalAnimationApi::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU){
            Languages.configureLocaleOnStartForDevicesLowerThanTiramisu(this)
        }

        setContent {
            IcarTheme(darkTheme = false) {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    val navController = rememberAnimatedNavController()
                    val navHostEngine = rememberNavHostEngine()

                    val newsBackStackEntry by navController.currentBackStackEntryAsState()
                    val route = newsBackStackEntry?.destination?.route

                    // need adjust the route to match the actual route
                    BottomNavigationBar(
                        navController = navController,
                        showBottomBar = route in listOf(
                            HomeScreenDestination.route,
                            TicketScreenDestination.route,
                            ProfileScreenDestination.route
                        )
                    ) { paddingValues ->
                        Box(
                            modifier = Modifier.padding(paddingValues)
                        ) {
                            DestinationsNavHost(
                                navGraph = NavGraphs.root,
                                navController = navController,
                                engine = navHostEngine
                            )
                        }
                    }
                }
            }
        }
    }
}