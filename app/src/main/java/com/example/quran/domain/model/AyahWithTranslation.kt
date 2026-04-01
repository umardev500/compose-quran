package com.example.quran.domain.model

data class AyahWithTranslation(
    val sura: Int,
    val aya: Int,
    val arabicText: String,
    val translationText: String?
)