package com.chocolatada.genshinimpactwiki.domain.utilities

import com.chocolatada.genshinimpactwiki.data.model.character.CharacterModel
import com.chocolatada.genshinimpactwiki.domain.dto.CharacterSearchScreenDTO

class Character {
    companion object {
        fun toCharacterSearchScreenDTO(characterModel: CharacterModel): CharacterSearchScreenDTO =
            CharacterSearchScreenDTO(
                characterModel.name,
                characterModel.urlIcon ?: "Not found"
            )
    }
}