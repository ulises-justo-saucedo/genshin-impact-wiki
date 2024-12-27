package com.chocolatada.genshinimpactwiki.view.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chocolatada.genshinimpactwiki.R
import com.chocolatada.genshinimpactwiki.view.Black
import com.chocolatada.genshinimpactwiki.view.BlueDT
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
            SearchBar(
                modifier = Modifier.fillMaxWidth(),
                onDone = { inputText ->
                    // Handle search input here
                }
            )
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier
                        .size(200.dp),
                    painter = painterResource(id = R.drawable.paimon_mainscreen),
                    contentDescription = "Image"
                )
                Text(
                    text = "Feel free to search whatever!",
                    color = White,
                    fontSize = 20.sp,
                    fontFamily = GenshinImpactFont
                )
            }
        }

        LazyColumn(
            modifier = Modifier
                .padding(start = 15.dp, end = 15.dp)
                .fillMaxWidth()
                .height(150.dp)
        ) {
            items(10) { iterator ->
                MyCard()
            }
        }

        BottomBar(
            onExplore = { /*TODO*/ },
            onSearch = { /*TODO*/ },
            onSaved = { /*TODO*/ }
        )
    }
}

@Composable
fun MyCard() {
    Card(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(bottom = 15.dp),
        colors = CardColors(BlueDT, White, BlueDT, White)
    ) {
        Text(text = "Random text so I can test this", color = White, fontFamily = GenshinImpactFont)
    }
}