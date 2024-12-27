package com.chocolatada.genshinimpactwiki.view.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chocolatada.genshinimpactwiki.view.Black
import com.chocolatada.genshinimpactwiki.view.GenshinImpactFont
import com.chocolatada.genshinimpactwiki.view.White
import com.chocolatada.genshinimpactwiki.view.bottombar.BottomBar
import com.chocolatada.genshinimpactwiki.view.searchbar.SearchBar

@Composable
@Preview(showBackground = true)
fun MainScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Black),
        verticalArrangement = Arrangement.SpaceBetween
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
            SearchBar(
                modifier = Modifier.fillMaxWidth(),
                onDone = { inputText ->
                    // Handle search input here
                }
            )
        }

        BottomBar(
            onExplore = { /*TODO*/ },
            onSearch = { /*TODO*/ },
            onSaved = { /*TODO*/ }
        )
    }
}