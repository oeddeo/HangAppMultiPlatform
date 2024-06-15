import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import data.di.KoinInitializer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.swing.Swing

//import kotlinx.coroutines.swing.Swing

fun main() = runBlocking() {
    KoinInitializer().init()
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "kmpKtor",
        ) {
            App()
        }
    }
}