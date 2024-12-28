package com.chocolatada.genshinimpactwiki.viewmodel

import androidx.lifecycle.ViewModel
import com.chocolatada.genshinimpactwiki.R
import com.chocolatada.genshinimpactwiki.data.api.keys.EntryKeys
import com.chocolatada.genshinimpactwiki.domain.dto.FieldMainScreenDTO
import dagger.hilt.android.lifecycle.HiltViewModel
import io.ktor.client.HttpClient
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
    val keysList = arrayOf(
        FieldMainScreenDTO(EntryKeys.CHARACTERS, R.drawable.characters),
        FieldMainScreenDTO(EntryKeys.ARTIFACTS, R.drawable.artifact),
        FieldMainScreenDTO(EntryKeys.BOSS, R.drawable.boss),
        FieldMainScreenDTO(EntryKeys.CONSUMABLES, R.drawable.consumable),
        FieldMainScreenDTO(EntryKeys.DOMAINS, R.drawable.domain),
        FieldMainScreenDTO(EntryKeys.ELEMENTS, R.drawable.element),
        FieldMainScreenDTO(EntryKeys.ENEMIES, R.drawable.enemies),
        FieldMainScreenDTO(EntryKeys.MATERIALS, R.drawable.material),
        FieldMainScreenDTO(EntryKeys.NATIONS, R.drawable.nation),
        FieldMainScreenDTO(EntryKeys.WEAPONS, R.drawable.weapons)
    )

}