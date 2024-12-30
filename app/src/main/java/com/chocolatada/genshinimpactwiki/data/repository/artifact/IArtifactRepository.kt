package com.chocolatada.genshinimpactwiki.data.repository.artifact

import com.chocolatada.genshinimpactwiki.data.model.artifact.ArtifactModel

interface IArtifactRepository {
    suspend fun getAll(): List<ArtifactModel>
}