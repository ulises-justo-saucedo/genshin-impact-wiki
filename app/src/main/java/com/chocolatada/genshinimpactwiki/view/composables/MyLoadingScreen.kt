package com.chocolatada.genshinimpactwiki.view.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.chocolatada.genshinimpactwiki.view.GenshinImpactFont
import com.chocolatada.genshinimpactwiki.view.White
import kotlinx.coroutines.delay

@Composable
fun MyLoadingScreen(
    loaded: Boolean
) {
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
        while(!loaded) {
            message = messages.random()
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