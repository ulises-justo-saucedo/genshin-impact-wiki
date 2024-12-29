package com.chocolatada.genshinimpactwiki.data.dao

import com.chocolatada.genshinimpactwiki.data.api.API
import com.chocolatada.genshinimpactwiki.data.api.keys.EntryKeys
import com.chocolatada.genshinimpactwiki.data.model.character.Character
import com.chocolatada.genshinimpactwiki.domain.dto.CharacterSearchScreenDTO
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.withContext
import okhttp3.internal.wait
import javax.inject.Inject

class CharacterDao @Inject constructor(
    private val httpClient: HttpClient
) {
    suspend fun getAll(): List<Character> {
        return withContext(Dispatchers.IO) {
            val ids: ArrayList<String> =
                httpClient.get(API.BASE_URL+EntryKeys.CHARACTERS).body()

            val response = ids.map { id ->
                async<Character> {
                    httpClient.get(API.BASE_URL+EntryKeys.CHARACTERS+"/$id/").body()
                }
            }.awaitAll()

            return@withContext response
        }
    }
}