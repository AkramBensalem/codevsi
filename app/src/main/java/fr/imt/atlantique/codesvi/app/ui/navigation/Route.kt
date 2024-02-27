package fr.imt.atlantique.codesvi.app.ui.navigation

sealed class RootScreen(val route: String) {
    data object Home : RootScreen("home_root")
    data object Login : RootScreen("login_root")
}

sealed class HomeRootScreen(val route: String) {
    data object Game : HomeRootScreen("game_screen")
    data object Profile : HomeRootScreen("profile_screen")
}
