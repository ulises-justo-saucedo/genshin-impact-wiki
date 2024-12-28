package com.chocolatada.genshinimpactwiki.view.container

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chocolatada.genshinimpactwiki.view.Black
import com.chocolatada.genshinimpactwiki.view.GenshinImpactFont
import com.chocolatada.genshinimpactwiki.view.White
import com.chocolatada.genshinimpactwiki.view.bottombar.BottomBar

@Composable
fun AppContainer(
    onExplore: () -> Unit,
    onSaved: () -> Unit,
    headerContent: @Composable () -> Unit = {},
    mainContent: @Composable () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Black),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .padding(start = 15.dp, top = 15.dp, end = 15.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Genshin Impact Wiki",
                color = White,
                fontFamily = GenshinImpactFont,
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 10.dp)
            )
            headerContent()
        }

        mainContent()

        BottomBar(
            onExplore = { onExplore() },
            onSaved = { onSaved() }
        )
    }
}