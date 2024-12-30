package com.chocolatada.genshinimpactwiki.data.dao

import com.chocolatada.genshinimpactwiki.data.api.API
import com.chocolatada.genshinimpactwiki.data.api.keys.EntryKeys
import com.chocolatada.genshinimpactwiki.data.model.artifact.ArtifactModel
import com.chocolatada.genshinimpactwiki.data.repository.artifact.IArtifactRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ArtifactDao @Inject constructor(
    private val httpClient: HttpClient
): IArtifactRepository {
    override suspend fun getAll(): List<ArtifactModel> {
        return withContext(Dispatchers.IO) {
            val ids: List<String> =
                httpClient.get(API.BASE_URL + EntryKeys.ARTIFACTS).body()

            val artifacts = ids.map { id ->
                async<ArtifactModel> {
                    httpClient.get(API.constructArtifactUrl(id)).body()
                }
            }.awaitAll()

            val response = artifacts.map { artifact ->
                async {
                    val artifactId = artifact.id.replaceFirstChar { it.lowercase() }
                    val urlIcon = API.constructArtifactIconUrl(artifactId)
                    ArtifactModel(
                        name = artifact.name,
                        id = artifactId,
                        urlIcon = urlIcon
                    )
                }
            }.awaitAll()

            return@withContext response
        }
    }
}