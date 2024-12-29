package com.chocolatada.genshinimpactwiki.data.repository.character

import com.chocolatada.genshinimpactwiki.data.model.character.Character

interface ICharacterRepository {
    suspend fun getAll(): List<Character>
}