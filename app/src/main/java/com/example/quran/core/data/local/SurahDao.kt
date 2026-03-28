package com.example.quran.core.data.local

import androidx.room.Dao
import androidx.room.Query
import com.example.quran.core.data.local.SurahEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SurahDao {
    @Query("SELECT * FROM surahs ORDER BY `s_index` ASC")
    fun getAllSurahs(): Flow<List<SurahEntity>>
}