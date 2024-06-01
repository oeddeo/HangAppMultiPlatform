import androidx.compose.ui.window.ComposeUIViewController
import data.di.KoinInitializer

fun MainViewController() = ComposeUIViewController(
    configure = {
        KoinInitializer().init()
    }
) { App() }