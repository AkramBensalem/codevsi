package fr.imt.atlantique.codesvi.app.ui.components.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Games
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import fr.imt.atlantique.codesvi.app.ui.navigation.HomeRootScreen

@Composable
fun BottomNavBar(
    currentSelectedScreen: HomeRootScreen,
    navigateToScreen: (HomeRootScreen) -> Unit
) {
    NavigationBar {
        NavigationBarItem(
            selected = currentSelectedScreen == HomeRootScreen.Game,
            onClick = { navigateToScreen(HomeRootScreen.Game) },
            alwaysShowLabel = true,
            label = {
                Text(text = "Accueil")
            },
            icon = {
                BottomNavIcon(
                    icon = Icons.Outlined.Games,
                    description = "Accueil"
                )
            }
        )
        NavigationBarItem(
            selected = currentSelectedScreen == HomeRootScreen.Profile,
            onClick = { navigateToScreen(HomeRootScreen.Profile) },
            alwaysShowLabel = true,
            label = { Text(text = "Profil") },
            icon = {
                BottomNavIcon(
                    icon = Icons.Outlined.AccountCircle,
                    description = "Profil"
                )
            }
        )
    }
}