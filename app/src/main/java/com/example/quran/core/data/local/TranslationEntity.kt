package com.example.quran.core.data.local

import androidx.room.Entity

@Entity(tableName = "translation", primaryKeys = ["sura", "aya"])
data class TranslationEntity(
    val sura: Int,
    val aya: Int,
    val text: String
)