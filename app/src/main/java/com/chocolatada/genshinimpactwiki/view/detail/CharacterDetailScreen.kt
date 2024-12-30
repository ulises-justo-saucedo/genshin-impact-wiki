package com.chocolatada.genshinimpactwiki.view.detail

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.chocolatada.genshinimpactwiki.view.GenshinImpactFont
import com.chocolatada.genshinimpactwiki.view.White
import com.chocolatada.genshinimpactwiki.view.container.AppContainer

@Composable
fun CharacterDetailScreen(
    onExplore: () -> Unit,
    onSaved: () -> Unit,
    id: String
) {
    AppContainer(
        onExplore = { onExplore() },
        onSaved = { onSaved() }
    ) {
        Text(
            text = "This character's ID is: $id",
            color = White,
            fontFamily = GenshinImpactFont
        )
    }
}