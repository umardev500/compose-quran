package com.example.quran.core.data.local

import androidx.room.Entity

@Entity(tableName = "quran", primaryKeys = ["sura", "aya"])
data class QuranEntity (
    val sura: Int,
    val aya: Int,
    val text: String
)