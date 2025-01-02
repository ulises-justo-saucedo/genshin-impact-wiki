package com.chocolatada.genshinimpactwiki.domain.utilities

import com.chocolatada.genshinimpactwiki.data.model.character.CharacterModel
import com.chocolatada.genshinimpactwiki.domain.dto.CharacterSearchScreenDTO

class CharacterUtilities {
    companion object {
        fun toCharacterSearchScreenDTO(characterModel: CharacterModel): CharacterSearchScreenDTO =
            CharacterSearchScreenDTO(
                characterModel.id,
                characterModel.name,
                characterModel.images?.urlIcon ?: "Not found"
            )
    }
}