package com.example.quran.feature.surah_detail.presentation

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import cafe.adriel.voyager.hilt.ScreenModelFactory
import com.example.quran.core.data.local.QuranDao
import com.example.quran.data.mapper.toDomain
import com.example.quran.domain.model.AyahWithTranslation
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SurahDetailViewModel @AssistedInject constructor(
    private val quranDao: QuranDao,
    @Assisted val surahId: Int
) : ScreenModel {
    @AssistedFactory
    interface Factory : ScreenModelFactory {
        fun create(surahId: Int): SurahDetailViewModel
    }

    private val _ayahs = MutableStateFlow(emptyList<AyahWithTranslation>())
    val ayahs: StateFlow<List<AyahWithTranslation>> = _ayahs

    init {
        screenModelScope.launch {
            quranDao.getAyahsWithTranslation(surahId).collect { list ->
                _ayahs.value = list.map { it.toDomain() }
            }
        }
    }
}