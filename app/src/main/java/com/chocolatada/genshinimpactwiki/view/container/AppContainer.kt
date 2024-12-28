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
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chocolatada.genshinimpactwiki.view.Black
import com.chocolatada.genshinimpactwiki.view.GenshinImpactFont
import com.chocolatada.genshinimpactwiki.view.White
import com.chocolatada.genshinimpactwiki.view.bottombar.BottomBar
import com.chocolatada.genshinimpactwiki.view.searchbar.SearchBar
import com.chocolatada.genshinimpactwiki.view.searchbar.SearchBarWithButtons

@Composable
fun AppContainer(
    onExplore: () -> Unit,
    onSaved: () -> Unit,
    onDone: (String) -> Unit,
    searchBarWithButtons: Boolean = false,
    onArrowBack: () -> Unit = {},
    headerContent: @Composable () -> Unit = {},
    mainContent: @Composable () -> Unit
) {
    val searchBarFocus = FocusRequester()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Black),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier.padding(start = 15.dp, top = 15.dp, end = 15.dp)
        ) {
            Text(
                text = "Genshin Impact Wiki",
                color = White,
                fontFamily = GenshinImpactFont,
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 10.dp)
            )
            if(!searchBarWithButtons) {
                SearchBar(
                    modifier = Modifier
                        .fillMaxWidth()
                        .focusRequester(searchBarFocus),
                    onDone = { inputText ->
                        searchBarFocus.freeFocus()
                        onDone(inputText)
                    }
                )
            } else {
                SearchBarWithButtons(
                    modifier = Modifier
                        .focusRequester(searchBarFocus),
                    onDone = { inputText ->
                        searchBarFocus.freeFocus()
                        onDone(inputText)
                    },
                    onArrowBack = { onArrowBack() }
                )
            }
            headerContent()
        }

        mainContent()

        BottomBar(
            onExplore = { onExplore() },
            onSearch = { searchBarFocus.requestFocus() },
            onSaved = { onSaved() }
        )
    }
}