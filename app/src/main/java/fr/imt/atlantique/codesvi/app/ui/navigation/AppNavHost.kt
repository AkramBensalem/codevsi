package fr.imt.atlantique.codesvi.app.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import fr.imt.atlantique.codesvi.app.ui.screens.game.GameScreen
import fr.imt.atlantique.codesvi.app.ui.screens.game.rememberGameState
import fr.imt.atlantique.codesvi.app.ui.screens.login.LoginScreen
import fr.imt.atlantique.codesvi.app.ui.screens.login.rememberLoginState
import fr.imt.atlantique.codesvi.app.ui.screens.profile.ProfileScreen
import fr.imt.atlantique.codesvi.app.ui.screens.profile.rememberProfileState
import fr.imt.atlantique.codesvi.app.utils.scaleInEnterTransition
import fr.imt.atlantique.codesvi.app.utils.scaleInPopEnterTransition
import fr.imt.atlantique.codesvi.app.utils.scaleOutExitTransition
import fr.imt.atlantique.codesvi.app.utils.scaleOutPopExitTransition

@Composable
fun AppNavHost(
    appState: AppState,
    modifier: Modifier = Modifier,
    padding: PaddingValues,
    startDestination: String = RootScreen.Login.route,
) {

    val navController = appState.navController
    val loginState = rememberLoginState(navController = navController)
    val gameState = rememberGameState(navController = navController)
    val profileState = rememberProfileState(navController = navController)


    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier.padding(padding),
    ) {

        composable(
            route = RootScreen.Login.route,
            enterTransition = { scaleInEnterTransition() },
            exitTransition = { scaleOutExitTransition() },
            popEnterTransition = { scaleInPopEnterTransition() },
            popExitTransition = { scaleOutPopExitTransition() },
        ) {
            LoginScreen(
                state = loginState,
                onNavigateToHome = { loginState.navigateTo(HomeRootScreen.Game) }
            )
        }

        navigation(
            route = RootScreen.Home.route,
            startDestination = HomeRootScreen.Game.route,
        ) {
            composable(
                route = HomeRootScreen.Game.route,
                enterTransition = { scaleInEnterTransition() },
                exitTransition = { scaleOutExitTransition() },
                popEnterTransition = { scaleInPopEnterTransition() },
                popExitTransition = { scaleOutPopExitTransition() },
            ) {


            //    val viewModel: GameViewModel = hiltViewModel()
           //     val screenState by viewModel.uiState.collectAsState()

                GameScreen(
                    modifier = Modifier.fillMaxSize(),
                    state = gameState
                )
            }
            composable(
                route = HomeRootScreen.Profile.route,
                enterTransition = { scaleInEnterTransition() },
                exitTransition = { scaleOutExitTransition() },
                popEnterTransition = { scaleInPopEnterTransition() },
                popExitTransition = { scaleOutPopExitTransition() },
            ) {

                ProfileScreen(
                    modifier = Modifier.fillMaxSize(),
                    state = profileState
                )
            }

        }

    }
}