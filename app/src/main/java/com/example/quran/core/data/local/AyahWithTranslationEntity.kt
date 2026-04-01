package com.example.quran.core.data.local

import androidx.room.ColumnInfo

data class AyahWithTranslationEntity(
    @ColumnInfo(name = "sura") val sura: Int,
    @ColumnInfo(name = "aya") val aya: Int,
    @ColumnInfo(name = "arabic_text") val arabicText: String,
    @ColumnInfo(name = "translation_text") val translationText: String?
)