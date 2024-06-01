import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import data.di.KoinInitializer

fun main() = application {
    KoinInitializer().init()
    Window(
        onCloseRequest = ::exitApplication,
        title = "kmpKtor",
    ) {
        App()
    }
}