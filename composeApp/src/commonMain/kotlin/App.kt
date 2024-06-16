import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import navigation.AppBottomNavigation
import navigation.SetupNavGraph
import org.koin.compose.KoinContext

@Composable
fun App() {
    val navController = rememberNavController()
    MaterialTheme {
        Scaffold(
            bottomBar = { AppBottomNavigation(navController = navController) }
        ) {
            KoinContext {
                SetupNavGraph(navController)
            }
        }
    }
}
