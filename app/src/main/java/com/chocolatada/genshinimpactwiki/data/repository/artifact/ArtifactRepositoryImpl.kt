package com.chocolatada.genshinimpactwiki.data.repository.artifact

import com.chocolatada.genshinimpactwiki.data.dao.ArtifactDao
import com.chocolatada.genshinimpactwiki.data.model.artifact.ArtifactModel
import javax.inject.Inject

class ArtifactRepositoryImpl @Inject constructor(
    private val artifactDao: ArtifactDao
): IArtifactRepository {
    override suspend fun getAll(): List<ArtifactModel> {
        //todo: same as character repository ! ! !
        return artifactDao.getAll()
    }

}