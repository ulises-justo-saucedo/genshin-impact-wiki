package com.chocolatada.genshinimpactwiki.view.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.chocolatada.genshinimpactwiki.domain.dto.ArtifactSearchScreenDTO
import com.chocolatada.genshinimpactwiki.domain.dto.CharacterSearchScreenDTO

@Composable
fun MyItemsList(
    array: List<*>
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp)
    ) {
        items(array.size) { iterator ->
            when(array[iterator]) {
                is CharacterSearchScreenDTO -> {
                    ShowCharacter(array[iterator] as CharacterSearchScreenDTO)
                }
                is ArtifactSearchScreenDTO -> {
                    ShowArtifact(array[iterator] as ArtifactSearchScreenDTO)
                }
            }
        }
    }
}

@Composable
fun ShowCharacter(character: CharacterSearchScreenDTO) {
    MyCard(
        iconUrl = character.iconUrl,
        text = character.name,
        lambdaParameter = "",
        onClick = {  }
    )
}

@Composable
fun ShowArtifact(artifact: ArtifactSearchScreenDTO) {
    MyCard(
        iconUrl = artifact.urlIcon,
        text = artifact.name,
        lambdaParameter = "",
        onClick = {  }
    )
}