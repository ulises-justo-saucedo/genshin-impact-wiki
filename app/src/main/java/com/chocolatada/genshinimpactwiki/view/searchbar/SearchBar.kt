package com.chocolatada.genshinimpactwiki.view.searchbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chocolatada.genshinimpactwiki.R
import com.chocolatada.genshinimpactwiki.view.Black
import com.chocolatada.genshinimpactwiki.view.BlueDT
import com.chocolatada.genshinimpactwiki.view.White

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    onDone: (String) -> Unit
) {
    var text by remember { mutableStateOf("") }
    TextField(
        modifier = modifier,
        value = text,
        onValueChange = { text = it },
        trailingIcon = {
            Image(
                painter = painterResource(id = R.drawable.search),
                contentDescription = "Search"
            )
        },
        colors = TextFieldDefaults.colors(
            focusedTextColor = White,
            unfocusedTextColor = White,
            focusedContainerColor = BlueDT,
            unfocusedContainerColor = BlueDT,
        ),
        shape = CircleShape,
        singleLine = true,
        keyboardActions = KeyboardActions(onDone = {
            onDone(text)
        })
    )
}