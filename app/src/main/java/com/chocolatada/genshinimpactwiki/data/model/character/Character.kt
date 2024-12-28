package com.chocolatada.genshinimpactwiki.data.model.character

import kotlinx.serialization.Serializable

@Serializable
data class Character(
    val name: String,
    val title: String,
    val vision: String
)
