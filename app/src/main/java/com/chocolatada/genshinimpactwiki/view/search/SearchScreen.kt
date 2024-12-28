package com.chocolatada.genshinimpactwiki.view.search

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.chocolatada.genshinimpactwiki.view.White
import com.chocolatada.genshinimpactwiki.view.container.AppContainer

@Composable
fun SearchScreen(
    inputText: String,
    onExplore: () -> Unit,
    onSaved: () -> Unit,
    onDone: (String) -> Unit,
    onArrowBack: () -> Unit
) {
    AppContainer(
        onExplore = { onExplore() },
        onSaved = { onSaved() },
        onDone = { newInputText -> onDone(newInputText) },
        searchBarWithButtons = true,
        onArrowBack = { onArrowBack() }
    ) {
        // todo: draw in screen every single register from the api that the user searched for
        Text(text = inputText, color = White)
    }
}