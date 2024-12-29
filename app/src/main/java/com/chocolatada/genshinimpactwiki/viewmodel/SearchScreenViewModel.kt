package com.chocolatada.genshinimpactwiki.viewmodel

import androidx.lifecycle.ViewModel
import com.chocolatada.genshinimpactwiki.data.dao.CharacterDao
import com.chocolatada.genshinimpactwiki.data.model.character.Character
import com.chocolatada.genshinimpactwiki.data.repository.character.ICharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SearchScreenViewModel @Inject constructor(
    private val characterRepository: ICharacterRepository
): ViewModel() {
    private val _loaded = MutableStateFlow(false)
    var loaded = _loaded

    lateinit var characters: List<Character>

    suspend fun getAll() {
        characters = characterRepository.getAll()
        _loaded.value = true
    }
}