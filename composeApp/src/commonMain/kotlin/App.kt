import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.navigation.compose.rememberNavController
import navigation.SetupNavGraph
import org.koin.compose.KoinContext
import viewModels.StartViewModel

@Composable
fun App() {
    MaterialTheme {
        KoinContext {
            val navController = rememberNavController()
            SetupNavGraph(navController)
        }
    }
}