package navigation


import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import screens.SecondScreen
import screens.StartScreen


@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screens.Start.route,
        modifier = Modifier.padding()
    ) {
        composable(route = Screens.Start.route) {
            StartScreen(
                onNextClick = {navController.navigate(Screens.Second.route)}
            )
        }
        composable(route = Screens.Second.route) {
            SecondScreen(navController::popBackStack)
        }
    }
}