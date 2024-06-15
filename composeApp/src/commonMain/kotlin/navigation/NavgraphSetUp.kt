package navigation


import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import screens.secondscreen.SecondScreen
import screens.startscreen.StartScreen


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
            StartScreen { answer -> navController.navigate("${Screens.Second.route}/$answer") }
        }
        composable(
            route = "${Screens.Second.route}/{answer}",
            arguments = listOf(navArgument("answer") {})
            ) {
            val answer = it.arguments?.getString("answer") ?: ""
            SecondScreen({ navController.navigate(Screens.Start.route) }, answer = answer)
        }

        }

}