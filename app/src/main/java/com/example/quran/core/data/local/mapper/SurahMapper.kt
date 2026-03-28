package com.example.quran.core.data.local.mapper

import com.example.quran.core.data.local.SurahEntity
import com.example.quran.feature.surah_list.domain.model.Surah

fun SurahEntity.toDomain(): Surah {
    return Surah(
        index = index,
        ayas = ayas,
        start = start,
        name = name,
        tname = tname,
        ename = ename,
        type = type,
        order = order,
        rukus = rukus
    )
}