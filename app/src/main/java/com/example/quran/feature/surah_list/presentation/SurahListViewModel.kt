package com.example.quran.feature.surah_list.presentation

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.example.quran.core.data.local.SurahDao
import com.example.quran.core.data.local.mapper.toDomain
import com.example.quran.feature.surah_list.domain.model.Surah
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class SurahListViewModel @Inject constructor(
    private val surahDao: SurahDao
) : ScreenModel {
    private val _surahs = MutableStateFlow(emptyList<Surah>())
    val surahs: StateFlow<List<Surah>> = _surahs

    init {
        screenModelScope.launch {
            surahDao.getAllSurahs().collect { list ->
                _surahs.value = list.map { it.toDomain() }
            }
        }
    }
}