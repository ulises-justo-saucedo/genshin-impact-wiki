package com.chocolatada.genshinimpactwiki.viewmodel

import androidx.lifecycle.ViewModel
import com.chocolatada.genshinimpactwiki.data.repository.character.ICharacterRepository
import com.chocolatada.genshinimpactwiki.domain.dto.CharacterSearchScreenDTO
import com.chocolatada.genshinimpactwiki.domain.utilities.CharacterUtilities
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class SearchCharacterScreenViewModel @Inject constructor(
    private val characterRepository: ICharacterRepository
): ViewModel() {
    private val _loaded = MutableStateFlow(false)
    var loaded = _loaded

    lateinit var characters: List<CharacterSearchScreenDTO>

    suspend fun getAll() {
        characters = characterRepository.getAll().map { character ->
            if(character.name.equals("traveler", true)) {
                character.name = "${character.name} - ${character.vision}"
            }
            CharacterUtilities.toCharacterSearchScreenDTO(
                character
            )
        }
        _loaded.value = true
    }
}