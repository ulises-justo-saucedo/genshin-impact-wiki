package com.chocolatada.genshinimpactwiki.data.api

import com.chocolatada.genshinimpactwiki.data.api.keys.characters.CharacterImageKeys
import com.chocolatada.genshinimpactwiki.data.api.keys.EntryKeys

class API {
    companion object {
        const val BASE_URL = "https://genshin.jmp.blue/"

        fun constructCharacterUrl(id: String) =
            API.BASE_URL + EntryKeys.CHARACTERS + "/$id/"

        fun constructCharacterIconUrl(id: String) =
            API.BASE_URL + "${EntryKeys.CHARACTERS}/${id}/${CharacterImageKeys.ICON}/"

        fun constructArtifactUrl(id: String) =
            API.BASE_URL + EntryKeys.ARTIFACTS + "/$id/"

        fun constructArtifactIconUrl(id: String) =
            API.BASE_URL + EntryKeys.ARTIFACTS + "/$id/flower-of-life.png"
    }
}