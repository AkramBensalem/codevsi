package fr.imt.atlantique.codesvi.app.ui.screens.game

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun GameScreen(
    state : GameState,
    modifier: Modifier = Modifier
) {
        Box(
            modifier = modifier,
            contentAlignment = Alignment.Center,
        ) {
            Text(text = "Game")
        }

}