package com.chocolatada.genshinimpactwiki.data.model.character

import kotlinx.serialization.Serializable

@Serializable
data class Constellation(
    val name: String,
    val unlock: String,
    val description: String,
    val level: Int
)
