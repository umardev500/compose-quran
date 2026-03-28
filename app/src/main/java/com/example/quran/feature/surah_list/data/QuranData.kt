package com.example.quran.feature.surah_list.data

import com.example.quran.feature.surah_list.domain.model.Surah

object QuranData {
    val surahs = listOf<Surah>(
        Surah(
            index = 1,
            ayas = 7,
            start = 0,
            name = "الفاتحة",
            tname = "Al-Faatiha",
            ename = "The Opening",
            type = "Meccan",
            order = 5,
            rukus = 1
        )
    )
}