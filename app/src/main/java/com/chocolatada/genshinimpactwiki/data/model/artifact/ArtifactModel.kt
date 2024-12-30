package com.chocolatada.genshinimpactwiki.data.model.artifact

import kotlinx.serialization.Serializable

@Serializable
data class ArtifactModel(
    val name: String,
    val id: String,
    val urlIcon: String? = null,
)