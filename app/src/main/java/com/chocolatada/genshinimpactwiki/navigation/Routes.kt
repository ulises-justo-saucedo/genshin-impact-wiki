package com.chocolatada.genshinimpactwiki.navigation

import kotlinx.serialization.Serializable

@Serializable
object Main

@Serializable
object SearchCharacter

@Serializable
data class CharacterDetail(val id: String)

@Serializable
object SearchArtifacts