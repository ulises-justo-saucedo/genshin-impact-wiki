package com.chocolatada.genshinimpactwiki.data.model.character

import kotlinx.serialization.Serializable

@Serializable
data class CharacterModel(
    var name: String,
    val title: String? = null,
    val vision: String,
    val weapon: String,
    val gender: String? = null,
    val nation: String,
    val affiliation: String,
    val rarity: Int,
    val release: String,
    val constellation: String,
    val skillTalents: List<Talent>,
    val constellations: List<Constellation>,
    val birthday: String,
    val description: String,
    val id: String,
    val images: Images? = null
)
