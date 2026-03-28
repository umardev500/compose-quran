package com.example.quran.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.quran.core.data.local.SurahEntity

@Database(entities = [SurahEntity::class], version = 1, exportSchema = true)
abstract class QuranDatabase : RoomDatabase() {
    abstract fun surahDao(): SurahDao
}