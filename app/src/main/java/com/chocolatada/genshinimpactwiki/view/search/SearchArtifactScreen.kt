package com.chocolatada.genshinimpactwiki.view.search

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import com.chocolatada.genshinimpactwiki.view.composables.MyItemsList
import com.chocolatada.genshinimpactwiki.view.composables.MyLoadingScreen
import com.chocolatada.genshinimpactwiki.view.container.AppContainer
import com.chocolatada.genshinimpactwiki.viewmodel.SearchArtifactScreenViewModel

@Composable
fun SearchArtifactScreen(
    onExplore: () -> Unit,
    onSaved: () -> Unit,
    viewModel: SearchArtifactScreenViewModel
) {
    val loaded = viewModel.loaded.collectAsState()
    LaunchedEffect(key1 = Unit) {
        viewModel.getAll()
    }
    AppContainer(
        onExplore = { onExplore() },
        onSaved = { onSaved() }
    ) {
        when(loaded.value) {
            true -> MyItemsList(array = viewModel.artifacts)
            false -> MyLoadingScreen(loaded = loaded.value)
        }
    }
}