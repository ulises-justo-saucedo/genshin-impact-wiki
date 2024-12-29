package com.chocolatada.genshinimpactwiki.data.repository.character

import com.chocolatada.genshinimpactwiki.data.dao.CharacterDao
import com.chocolatada.genshinimpactwiki.data.model.character.CharacterModel
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val characterApiDao: CharacterDao
): ICharacterRepository {
    override suspend fun getAll(): List<CharacterModel> {
        //todo("fetch data from api or local database if possible o-o")
        return characterApiDao.getAll()
    }
}