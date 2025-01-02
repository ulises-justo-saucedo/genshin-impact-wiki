package com.chocolatada.genshinimpactwiki.viewmodel

import androidx.lifecycle.ViewModel
import com.chocolatada.genshinimpactwiki.data.model.character.CharacterModel
import com.chocolatada.genshinimpactwiki.data.repository.character.ICharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class CharacterDetailScreenViewModel @Inject constructor(
    private val repository: ICharacterRepository
) : ViewModel() {
    private val _loaded = MutableStateFlow(false)
    val loaded = _loaded

    lateinit var character: CharacterModel

    suspend fun getById(id: String) {
        character = repository.getById(id)
        _loaded.value = true
    }
}