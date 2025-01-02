package com.chocolatada.genshinimpactwiki.data.dao

import com.chocolatada.genshinimpactwiki.data.api.API
import com.chocolatada.genshinimpactwiki.data.api.keys.EntryKeys
import com.chocolatada.genshinimpactwiki.data.model.character.CharacterModel
import com.chocolatada.genshinimpactwiki.data.repository.character.ICharacterRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CharacterDao @Inject constructor(
    private val httpClient: HttpClient
): ICharacterRepository {
    override suspend fun getAll(): List<CharacterModel> {
        return withContext(Dispatchers.IO) {
            val ids: ArrayList<String> =
                httpClient.get(API.BASE_URL + EntryKeys.CHARACTERS).body()

            val characterModels = ids.map { id ->
                async<CharacterModel> {
                    httpClient.get(API.constructCharacterUrl(id)).body()
                }
            }.awaitAll()

            val response = characterModels.map { character ->
                async {
                    val charId = character.id.replaceFirstChar { it.lowercase() }
                    CharacterModel(
                        name = character.name,
                        title = character.title,
                        vision = character.vision,
                        weapon = character.weapon,
                        gender = character.gender,
                        nation = character.nation,
                        affiliation = character.affiliation,
                        rarity = character.rarity,
                        release = character.release,
                        constellation = character.constellation,
                        skillTalents = character.skillTalents,
                        constellations = character.constellations,
                        birthday = character.birthday,
                        description = character.description,
                        id = charId,
                        images = API.constructCharacterImages(charId)
                    )
                }
            }.awaitAll()
            return@withContext response
        }
    }

    override suspend fun getById(id: String): CharacterModel {
        return withContext(Dispatchers.IO) {
            val character: CharacterModel = httpClient.get(API.constructCharacterUrl(id)).body()

            val response = CharacterModel(
                name = character.name,
                title = character.title,
                vision = character.vision,
                weapon = character.weapon,
                gender = character.gender,
                nation = character.nation,
                affiliation = character.affiliation,
                rarity = character.rarity,
                release = character.release,
                constellation = character.constellation,
                skillTalents = character.skillTalents,
                constellations = character.constellations,
                birthday = character.birthday,
                description = character.description,
                id = id,
                images = API.constructCharacterImages(id)
            )

            return@withContext response
        }
    }
}