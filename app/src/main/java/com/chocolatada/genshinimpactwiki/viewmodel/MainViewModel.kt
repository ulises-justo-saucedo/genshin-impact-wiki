package com.chocolatada.genshinimpactwiki.viewmodel

import androidx.lifecycle.ViewModel
import com.chocolatada.genshinimpactwiki.data.api.keys.EntryKeys
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
    val keysList = arrayOf(
        EntryKeys.CHARACTERS,
        EntryKeys.ARTIFACTS,
        EntryKeys.BOSS,
        EntryKeys.CONSUMABLES,
        EntryKeys.DOMAINS,
        EntryKeys.ELEMENTS,
        EntryKeys.ENEMIES,
        EntryKeys.MATERIALS,
        EntryKeys.NATIONS,
        EntryKeys.WEAPONS
    )
}