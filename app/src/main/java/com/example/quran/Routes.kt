package com.example.quran

import cafe.adriel.voyager.core.screen.Screen
import com.example.quran.feature.search.SearchScreen
import com.example.quran.feature.surah_detail.presentation.SurahDetailScreen
import com.example.quran.feature.surah_list.presentation.SurahListScreen

object Routes {
    fun surahList(): Screen = SurahListScreen()
    fun search(): Screen = SearchScreen()
    fun surahDetail(surahId: Int, surahName: String): Screen = SurahDetailScreen(surahId, surahName)
}
