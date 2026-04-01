package com.example.quran.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [SurahEntity::class, QuranEntity::class, TranslationEntity::class], version = 1, exportSchema = true)
abstract class QuranDatabase : RoomDatabase() {
    abstract fun quranDao(): QuranDao
}