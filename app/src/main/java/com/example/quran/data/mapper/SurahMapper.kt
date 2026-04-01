package com.example.quran.data.mapper

import com.example.quran.core.data.local.SurahEntity
import com.example.quran.domain.model.Surah

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