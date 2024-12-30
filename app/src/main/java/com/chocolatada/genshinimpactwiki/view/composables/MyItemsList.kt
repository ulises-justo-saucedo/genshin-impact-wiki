package com.chocolatada.genshinimpactwiki.view.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.chocolatada.genshinimpactwiki.domain.dto.ArtifactSearchScreenDTO
import com.chocolatada.genshinimpactwiki.domain.dto.CharacterSearchScreenDTO
import com.chocolatada.genshinimpactwiki.navigation.CharacterDetail

@Composable
fun MyItemsList(
    array: List<*>,
    onItemDetail: (String) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp)
    ) {
        items(array.size) { iterator ->
            when(array[iterator]) {
                is CharacterSearchScreenDTO -> {
                    ShowCharacter(
                        character = array[iterator] as CharacterSearchScreenDTO,
                        onItemDetail = onItemDetail
                    )
                }
                is ArtifactSearchScreenDTO -> {
                    ShowArtifact(array[iterator] as ArtifactSearchScreenDTO)
                }
            }
        }
    }
}

@Composable
fun ShowCharacter(
    character: CharacterSearchScreenDTO,
    onItemDetail: (String) -> Unit
) {
    MyCard(
        iconUrl = character.iconUrl,
        text = character.name,
        onClick = { onItemDetail(character.id) }
    )
}

@Composable
fun ShowArtifact(artifact: ArtifactSearchScreenDTO) {
    MyCard(
        iconUrl = artifact.urlIcon,
        text = artifact.name,
        onClick = {  }
    )
}