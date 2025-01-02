package com.chocolatada.genshinimpactwiki.data.api

import com.chocolatada.genshinimpactwiki.data.api.keys.characters.CharacterImageKeys
import com.chocolatada.genshinimpactwiki.data.api.keys.EntryKeys
import com.chocolatada.genshinimpactwiki.data.model.character.Images

class API {
    companion object {
        const val BASE_URL = "https://genshin.jmp.blue/"

        //todo: maybe separate these functions into different classes?

        // character functions
        fun constructCharacterUrl(id: String) =
            API.BASE_URL + EntryKeys.CHARACTERS + "/$id/"

        fun constructCharacterImages(id: String): Images = Images(
            constructCharacterIconUrl(id),
            constructCharacterSplashArtUrl(id),
            constructCharacterTalentUrl(id, CharacterImageKeys.TALENT_BURST),
            constructCharacterTalentUrl(id, CharacterImageKeys.TALENT_NORMAL_ATTACK),
            constructCharacterTalentUrl(id, CharacterImageKeys.TALENT_ELEMENTAL_SKILL),
            constructCharacterConstellationUrl(id, CharacterImageKeys.CONSTELLATION_ART),
            constructCharacterConstellationUrl(id, CharacterImageKeys.CONSTELLATION_ONE),
            constructCharacterConstellationUrl(id, CharacterImageKeys.CONSTELLATION_TWO),
            constructCharacterConstellationUrl(id, CharacterImageKeys.CONSTELLATION_THREE),
            constructCharacterConstellationUrl(id, CharacterImageKeys.CONSTELLATION_FOUR),
            constructCharacterConstellationUrl(id, CharacterImageKeys.CONSTELLATION_FIVE),
            constructCharacterConstellationUrl(id, CharacterImageKeys.CONSTELLATION_SIX)
        )

        private fun constructCharacterIconUrl(id: String): String =
            API.BASE_URL + "${EntryKeys.CHARACTERS}/${id}/${CharacterImageKeys.ICON}/"

        private fun constructCharacterSplashArtUrl(id: String): String =
            API.BASE_URL + "${EntryKeys.CHARACTERS}/${id}/${CharacterImageKeys.SPLASH_ART}/"

        private fun constructCharacterTalentUrl(id: String, key: String): String =
            BASE_URL + EntryKeys.CHARACTERS + "/$id/" + key + "/"

        private fun constructCharacterConstellationUrl(id: String, key: String): String =
            BASE_URL + EntryKeys.CHARACTERS + "/$id/" + key + "/"

        // artifact functions
        fun constructArtifactUrl(id: String) =
            API.BASE_URL + EntryKeys.ARTIFACTS + "/$id/"

        fun constructArtifactIconUrl(id: String) =
            API.BASE_URL + EntryKeys.ARTIFACTS + "/$id/flower-of-life.png"
    }
}