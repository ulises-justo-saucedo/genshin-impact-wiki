package com.chocolatada.genshinimpactwiki.data.model.character

import kotlinx.serialization.Serializable

@Serializable
data class CharacterModel(
    var name: String,
    val title: String? = null,
    val vision: String,
    val id: String,
    val urlIcon: String? = null
)
