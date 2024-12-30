package com.chocolatada.genshinimpactwiki.viewmodel

import androidx.lifecycle.ViewModel
import com.chocolatada.genshinimpactwiki.data.repository.artifact.IArtifactRepository
import com.chocolatada.genshinimpactwiki.domain.dto.ArtifactSearchScreenDTO
import com.chocolatada.genshinimpactwiki.domain.utilities.ArtifactUtilities
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class SearchArtifactScreenViewModel @Inject constructor(
    private val artifactRepository: IArtifactRepository
): ViewModel() {
    private val _loaded = MutableStateFlow(false)
    val loaded = _loaded

    lateinit var artifacts: List<ArtifactSearchScreenDTO>

    suspend fun getAll() {
        artifacts = artifactRepository.getAll().map { artifact ->
            ArtifactUtilities.toArtifactSearchScreenDTO(artifact)
        }
        _loaded.value = true
    }
}