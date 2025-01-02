package com.chocolatada.genshinimpactwiki.data.model.character

import kotlinx.serialization.Serializable

@Serializable
data class Images(
    val urlIcon: String,
    val urlSplashArt: String,
    val urlTalentBurst: String,
    val urlTalentNormalAttack: String,
    val urlTalentElementalSkill: String,
    val urlConstellationArt: String,
    val urlConstellationOne: String,
    val urlConstellationTwo: String,
    val urlConstellationThree: String,
    val urlConstellationFour: String,
    val urlConstellationFive: String,
    val urlConstellationSix: String
)
