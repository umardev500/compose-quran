package com.example.quran.core.data.local

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface QuranDao {
    @Query("SELECT * FROM surahs ORDER BY `s_index` ASC")
    fun getAllSurahs(): Flow<List<SurahEntity>>

    @Query("SELECT * FROM quran WHERE sura = :suraId AND aya = :ayaId")
    fun getAyah(suraId: Int, ayaId: Int): Flow<List<QuranEntity>>

    @Query("SELECT * FROM quran WHERE sura = :suraId")
    fun getAyahs(suraId: Int): Flow<List<QuranEntity>>

    @Query("""
        SELECT q.sura, q.aya, q.text AS arabic_text, t.text AS translation_text
        FROM quran q
        LEFT JOIN translation t
        ON q.sura = t.sura AND q.aya = t.aya
        WHERE q.sura = :surahId
        ORDER BY q.aya ASC
    """)
    fun getAyahsWithTranslation(surahId: Int): Flow<List<AyahWithTranslationEntity>>
}