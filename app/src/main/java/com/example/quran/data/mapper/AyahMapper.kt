package com.example.quran.data.mapper

import com.example.quran.core.data.local.AyahWithTranslationEntity
import com.example.quran.core.data.local.QuranEntity
import com.example.quran.domain.model.Ayah
import com.example.quran.domain.model.AyahWithTranslation

fun QuranEntity.toDomain(): Ayah {
    return Ayah(
        sura = sura,
        aya = aya,
        text = text
    )
}

fun AyahWithTranslationEntity.toDomain(): AyahWithTranslation {
    return AyahWithTranslation(
        sura = sura,
        aya = aya,
        arabicText = arabicText,
        translationText = translationText
    )
}