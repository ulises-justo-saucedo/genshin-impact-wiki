package com.chocolatada.genshinimpactwiki.domain.utilities

import com.chocolatada.genshinimpactwiki.data.model.artifact.ArtifactModel
import com.chocolatada.genshinimpactwiki.domain.dto.ArtifactSearchScreenDTO

class ArtifactUtilities {
    companion object {
        fun toArtifactSearchScreenDTO(artifact: ArtifactModel) =
            ArtifactSearchScreenDTO(
                artifact.name,
                artifact.urlIcon ?: "Not found"
            )
    }
}