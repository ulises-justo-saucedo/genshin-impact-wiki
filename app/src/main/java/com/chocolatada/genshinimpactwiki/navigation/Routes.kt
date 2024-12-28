package com.chocolatada.genshinimpactwiki.navigation

import kotlinx.serialization.Serializable

@Serializable
object Main

@Serializable
data class Search(val inputText: String)