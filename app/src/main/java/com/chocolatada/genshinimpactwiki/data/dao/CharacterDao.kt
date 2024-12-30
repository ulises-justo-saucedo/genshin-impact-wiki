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
                    val urlString = API.constructCharacterIconUrl(charId)
                    CharacterModel(
                        name = character.name,
                        title = character.title,
                        vision = character.vision,
                        id = charId,
                        urlIcon = urlString
                    )
                }
            }.awaitAll()
            return@withContext response
        }
    }
}