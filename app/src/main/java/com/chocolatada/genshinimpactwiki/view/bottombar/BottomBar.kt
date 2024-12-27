package com.chocolatada.genshinimpactwiki.view.bottombar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.chocolatada.genshinimpactwiki.R
import com.chocolatada.genshinimpactwiki.view.BlueDT
import com.chocolatada.genshinimpactwiki.view.GenshinImpactFont
import com.chocolatada.genshinimpactwiki.view.White

@Composable
fun BottomBar(
    onExplore: () -> Unit,
    onSearch: () -> Unit,
    onSaved: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .background(BlueDT)
            .padding(10.dp)
    ) {
        Icon(
            icon = R.drawable.explore,
            description = "Explore",
            onClick = onExplore
        )
        Icon(
            icon = R.drawable.search,
            description = "Search",
            onClick = onSearch
        )
        Icon(
            icon = R.drawable.saved,
            description = "Saved",
            onClick = onSaved
        )
    }
}

@Composable
fun Icon(
    icon: Int,
    description: String,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .clickable { onClick() }
            .padding(end = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = description,
            modifier = Modifier.size(35.dp)
        )
        Text(
            text = description,
            color = White,
            fontFamily = GenshinImpactFont
        )
    }
}