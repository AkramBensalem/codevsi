package fr.imt.atlantique.codesvi.app.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import fr.imt.atlantique.codesvi.app.ui.components.navigation.BottomNavBar
import fr.imt.atlantique.codesvi.app.ui.navigation.AppNavHost
import fr.imt.atlantique.codesvi.app.ui.navigation.rememberAppState
import fr.imt.atlantique.codesvi.app.ui.screens.settings.Theme
import fr.imt.atlantique.codesvi.app.ui.theme.AppTheme

@Composable
fun MainUI() {

    val appState = rememberAppState()

    AppTheme(
        theme = Theme.FOLLOW_SYSTEM
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .systemBarsPadding(),
            color = MaterialTheme.colorScheme.background
        ) {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                topBar = {},
                bottomBar = {
                    AnimatedVisibility(
                        visible = appState.isBottomBarVisible,
                        enter = fadeIn() + slideInVertically(
                            initialOffsetY = { it }
                        ),
                        exit = fadeOut() + slideOutVertically(
                            targetOffsetY = { it }
                        )
                    ) {
                        BottomNavBar(
                            currentSelectedScreen = appState.currentSelectedBottomNav,
                            navigateToScreen = { appState.navigateInsideHome(it) }
                        )
                    }
                },
                containerColor = MaterialTheme.colorScheme.background,
                contentColor = MaterialTheme.colorScheme.onBackground,
            ) { padding ->
                AppNavHost(
                    appState = appState,
                    padding = padding
                )
            }
        }
    }
}