package com.chocolatada.genshinimpactwiki.data.model.character

import kotlinx.serialization.Serializable

@Serializable
class Talent(
    val name: String,
    val unlock: String,
    val description: String,
    val type: String? = null
) {
    companion object {
        val BURST = "ELEMENTAL_BURST"
        val NORMAL_ATTACK = "NORMAL_ATTACK"
        val ELEMENTAL_SKILL = "ELEMENTAL_SKILL"
    }
}
