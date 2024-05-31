package navigation

sealed class Screens(val route: String) {
    object Start : Screens("app_screen_start")
    object Second : Screens("app_screen_second")
}