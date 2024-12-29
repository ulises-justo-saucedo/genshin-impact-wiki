package com.chocolatada.genshinimpactwiki.view.search

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.chocolatada.genshinimpactwiki.view.GenshinImpactFont
import com.chocolatada.genshinimpactwiki.view.White
import com.chocolatada.genshinimpactwiki.view.container.AppContainer
import com.chocolatada.genshinimpactwiki.viewmodel.SearchScreenViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SearchScreen(
    onExplore: () -> Unit,
    onSaved: () -> Unit,
    searchScreenViewModel: SearchScreenViewModel,
    key: String
) {
    val loaded = searchScreenViewModel.loaded.collectAsState()
    var message by remember { mutableStateOf("") }
    val messages = remember {
        listOf(
            "Fetching data . . .",
            "Just one moment, please . . .",
            "Loading . . .",
            "Paimon could help us . . .",
            "Please wait a second . . .",
        )
    }
    LaunchedEffect(key1 = Unit) {
        searchScreenViewModel.getAll()
    }
    AppContainer(
        onExplore = { onExplore() },
        onSaved = { onSaved() }
    ) {
        if(loaded.value) {
            LazyColumn {
                items(searchScreenViewModel.characters.size) { iterator ->
                    val currentCharacter = searchScreenViewModel.characters[iterator]
                    Text(
                        text = "${currentCharacter.name}, ${currentCharacter.title}, ${currentCharacter.vision}",
                        color = White
                    )
                }
            }
        } else {
            LaunchedEffect(key1 = Unit) {
                while(!loaded.value) {
                    message = messages.random()
                    Log.d("SearchScreen", "message: $message")
                    delay(2000)
                }
            }
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator()
                Text(
                    text = message,
                    color = White,
                    fontFamily = GenshinImpactFont
                )
            }
        }
    }
}