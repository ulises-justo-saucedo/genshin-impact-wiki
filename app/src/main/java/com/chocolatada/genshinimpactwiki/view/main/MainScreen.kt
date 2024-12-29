package com.chocolatada.genshinimpactwiki.view.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import com.chocolatada.genshinimpactwiki.domain.dto.FieldMainScreenDTO
import com.chocolatada.genshinimpactwiki.view.BlueDT
import com.chocolatada.genshinimpactwiki.view.GenshinImpactFont
import com.chocolatada.genshinimpactwiki.view.White
import com.chocolatada.genshinimpactwiki.view.container.AppContainer
import com.chocolatada.genshinimpactwiki.viewmodel.MainViewModel

@Composable
@Preview(showBackground = true)
fun MainScreenPreview() {
    MainScreen(mainViewModel = MainViewModel(), {}, {}, {})
}

@Composable
fun MainScreen(
    mainViewModel: MainViewModel,
    onExplore: () -> Unit,
    onSaved: () -> Unit,
    onSearch: (String) -> Unit
) {
    val scrollState = rememberScrollState()
    AppContainer(
        onExplore = { onExplore() },
        onSaved = { onSaved() },
        headerContent = { HeaderContent() }
    ) {
        Column(
            modifier = Modifier
                .padding(start = 15.dp, end = 15.dp)
                .fillMaxWidth()
                .height(150.dp)
                .verticalScroll(scrollState)
        ) {
            for(i in 0..<mainViewModel.keysList.size) {
                MyCard(
                    fieldMainScreenDTO = mainViewModel.keysList[i],
                    onSearch = onSearch
                )
            }
        }
    }
}

@Composable
fun HeaderContent() {
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

@Composable
fun MyCard(
    fieldMainScreenDTO: FieldMainScreenDTO,
    onSearch: (String) -> Unit
) {
    Card(
        onClick = { onSearch(fieldMainScreenDTO.key) },
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(bottom = 15.dp),
        colors = CardColors(BlueDT, White, BlueDT, White)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = fieldMainScreenDTO.icon),
                contentDescription = "Artifact Icon",
                modifier = Modifier.size(90.dp)
            )
            Text(
                text = fieldMainScreenDTO.key.replaceFirstChar { it.uppercase() },
                color = White,
                fontFamily = GenshinImpactFont,
                modifier = Modifier.padding(end = 60.dp),
                fontSize = 20.sp
            )
        }
    }
}