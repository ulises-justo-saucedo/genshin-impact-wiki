package com.chocolatada.genshinimpactwiki.data.repository.character

import com.chocolatada.genshinimpactwiki.data.model.character.CharacterModel

interface ICharacterRepository {
    suspend fun getAll(): List<CharacterModel>
}