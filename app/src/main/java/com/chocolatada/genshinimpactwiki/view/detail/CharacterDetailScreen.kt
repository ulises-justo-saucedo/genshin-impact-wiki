package com.chocolatada.genshinimpactwiki.view.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.chocolatada.genshinimpactwiki.R
import com.chocolatada.genshinimpactwiki.data.model.character.CharacterModel
import com.chocolatada.genshinimpactwiki.data.model.character.Constellation
import com.chocolatada.genshinimpactwiki.data.model.character.Talent
import com.chocolatada.genshinimpactwiki.view.GenshinImpactFont
import com.chocolatada.genshinimpactwiki.view.White
import com.chocolatada.genshinimpactwiki.view.composables.MyLoadingScreen
import com.chocolatada.genshinimpactwiki.view.container.AppContainer
import com.chocolatada.genshinimpactwiki.viewmodel.CharacterDetailScreenViewModel

@Composable
fun CharacterDetailScreen(
    onExplore: () -> Unit,
    onSaved: () -> Unit,
    id: String,
    viewModel: CharacterDetailScreenViewModel
) {
    val loadedCharacter = viewModel.loaded.collectAsState()
    var imagesDownloadFailed by remember { mutableStateOf(false) }
    var downloadingImages by remember { mutableStateOf(true) }
    LaunchedEffect(key1 = Unit) {
        viewModel.getById(id)
    }
    AppContainer(
        onExplore = { onExplore() },
        onSaved = { onSaved() }
    ) {
        when (loadedCharacter.value) {
            true -> {
                ShowThisCharacter(
                    character = viewModel.character,
                    onErrorImage = {
                        imagesDownloadFailed = true
                        downloadingImages = false
                    },
                    onSuccessImage = { downloadingImages = false },
                    imagesDownloadFailed = imagesDownloadFailed,
                    downloadingImages = downloadingImages
                )
            }

            false -> MyLoadingScreen(loaded = loadedCharacter.value)
        }
    }
}

@Composable
fun ShowThisCharacter(
    character: CharacterModel,
    onErrorImage: () -> Unit,
    onSuccessImage: () -> Unit,
    imagesDownloadFailed: Boolean,
    downloadingImages: Boolean
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp)
            .verticalScroll(scrollState)
            .padding(start = 15.dp, end = 15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (downloadingImages) {
            MyLoadingScreen(loaded = !downloadingImages)
        }
        if (imagesDownloadFailed) {
            ShowDownloadFailedErrorMessage(characterName = character.name)
        } else {
            ShowCharacterSplashArt(
                character = character,
                onErrorImage = onErrorImage,
                onSuccessImage = onSuccessImage
            )
        }
        ShowCharacterPresentation(character = character)
        ShowCharacterTalents(character = character)
        ShowCharacterConstellations(character = character)
    }
}

@Composable
fun ShowDownloadFailedErrorMessage(characterName: String) {
    MyText(text = "Sorry... Couldn't download ${characterName}'s splash art...", fontSize = 30)
    Image(
        painter = painterResource(id = R.drawable.paimon_fail),
        contentDescription = "Paimon Fail image"
    )
}

@Composable
fun ShowCharacterSplashArt(
    character: CharacterModel,
    onErrorImage: () -> Unit,
    onSuccessImage: () -> Unit
) {
    if (character.images != null) { // this shouldn't be null at this point but ok -o-
        AsyncImage(
            model = character.images.urlSplashArt,
            contentDescription = "${character.images.urlSplashArt} icon",
            modifier = Modifier
                .fillMaxWidth()
                .size(300.dp),
            onError = { onErrorImage() },
            onSuccess = { onSuccessImage() },
            filterQuality = FilterQuality.None
        )
    }
}

@Composable
fun ShowCharacterPresentation(character: CharacterModel) {
    MyText(text = character.name, fontSize = 30)
    when (character.rarity) {
        5 -> {
            Image(
                painter = painterResource(id = R.drawable.five_stars),
                contentDescription = "Five Stars",
                modifier = Modifier
                    .fillMaxWidth()
                    .size(40.dp)
            )
        }

        4 -> {
            Image(
                painter = painterResource(id = R.drawable.four_stars),
                contentDescription = "Four Stars",
                modifier = Modifier
                    .fillMaxWidth()
                    .size(40.dp)
            )
        }
    }
    if (character.title != null) {
        Spacer(modifier = Modifier.height(10.dp))
        MyText(text = character.title, fontSize = 20)
    }
    Spacer(modifier = Modifier.height(10.dp))
    MyText(text = character.description, fontSize = 15)
    Spacer(modifier = Modifier.height(10.dp))
    MyText(
        text = "${character.name} is a ${character.weapon} and ${character.vision} user from ${character.nation}, affiliated to the ${character.affiliation}.",
        fontSize = 15
    )
}

@Composable
fun ShowCharacterTalents(character: CharacterModel) {
    if(character.images != null) {
        Spacer(modifier = Modifier.height(40.dp))
        MyText(text = "Talents", fontSize = 20)
        Spacer(modifier = Modifier.height(10.dp))
        character.skillTalents.forEach { talent ->
            when(talent.type) {
                Talent.BURST -> {
                    ShowTalent(talent) {
                        AsyncImage(
                            model = character.images.urlTalentBurst,
                            contentDescription = null
                        )
                    }
                }
                Talent.NORMAL_ATTACK -> {
                    ShowTalent(talent) {
                        AsyncImage(
                            model = character.images.urlTalentNormalAttack,
                            contentDescription = null
                        )
                    }
                }
                Talent.ELEMENTAL_SKILL -> {
                    ShowTalent(talent) {
                        AsyncImage(
                            model = character.images.urlTalentElementalSkill,
                            contentDescription = null
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ShowTalent(talent: Talent, image: @Composable () -> Unit) {
    MyHorizontalDivider()
    Spacer(modifier = Modifier.height(10.dp))
    MyText(text = talent.name, fontSize = 20)
    MyText(text = talent.unlock, fontSize = 15)
    Spacer(modifier = Modifier.height(10.dp))
    image()
    Spacer(modifier = Modifier.height(10.dp))
    MyText(text = talent.description, fontSize = 15)
    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun ShowCharacterConstellations(character: CharacterModel) {
    if (character.images != null) {
        Spacer(modifier = Modifier.height(40.dp))
        MyText(text = "Constellation: ${character.constellation}", fontSize = 20)
        AsyncImage(model = character.images.urlConstellationArt, contentDescription = null)
        character.constellations.forEach { constellation ->
            when (constellation.level) {
                1 -> {
                    ShowConstellation(constellation = constellation) {
                        AsyncImage(
                            model = character.images.urlConstellationOne,
                            contentDescription = null
                        )
                    }
                }

                2 -> {
                    ShowConstellation(constellation = constellation) {
                        AsyncImage(
                            model = character.images.urlConstellationTwo,
                            contentDescription = null
                        )
                    }
                }

                3 -> {
                    ShowConstellation(constellation = constellation) {
                        AsyncImage(
                            model = character.images.urlConstellationThree,
                            contentDescription = null
                        )
                    }
                }

                4 -> {
                    ShowConstellation(constellation = constellation) {
                        AsyncImage(
                            model = character.images.urlConstellationFour,
                            contentDescription = null
                        )
                    }
                }

                5 -> {
                    ShowConstellation(constellation = constellation) {
                        AsyncImage(
                            model = character.images.urlConstellationFive,
                            contentDescription = null
                        )
                    }
                }

                6 -> {
                    ShowConstellation(constellation = constellation) {
                        AsyncImage(
                            model = character.images.urlConstellationSix,
                            contentDescription = null
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ShowConstellation(constellation: Constellation, image: @Composable () -> Unit) {
    Spacer(modifier = Modifier.height(10.dp))
    MyHorizontalDivider()
    Spacer(modifier = Modifier.height(10.dp))
    MyText(text = constellation.unlock, fontSize = 20)
    MyText(text = constellation.name, fontSize = 15)
    Spacer(modifier = Modifier.height(10.dp))
    image()
    Spacer(modifier = Modifier.height(10.dp))
    MyText(text = constellation.description, fontSize = 15)
}

@Composable
fun MyText(text: String, fontSize: Int) {
    Text(
        text = text,
        color = White,
        fontFamily = GenshinImpactFont,
        fontSize = fontSize.sp,
        textAlign = TextAlign.Center
    )
}

@Composable
fun MyHorizontalDivider() {
    HorizontalDivider(modifier = Modifier.fillMaxWidth(), thickness = 1.dp, color = White)
}