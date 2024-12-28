package com.chocolatada.genshinimpactwiki.view.searchbar

import android.graphics.Paint.Align
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.chocolatada.genshinimpactwiki.R

@Composable
@Preview(showBackground = false)
fun SearchBarWithButtonsPreview() {
    SearchBarWithButtons(onDone = {}, onArrowBack = {})
}

@Composable
fun SearchBarWithButtons(
    modifier: Modifier = Modifier,
    onDone: (String) -> Unit,
    onArrowBack: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.arrow_back),
            contentDescription = "Arrow Back",
            modifier = Modifier.clickable { onArrowBack() }
        )
        SearchBar(modifier = modifier) { inputText ->
            onDone(inputText)
        }
        Image(
            painter = painterResource(id = R.drawable.three_dots),
            contentDescription = "Three Dots",
            modifier = Modifier.clickable {  }
        )
    }
}