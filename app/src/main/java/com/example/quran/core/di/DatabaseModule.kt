package com.example.quran.core.di

import android.content.Context
import androidx.room.Room
import com.example.quran.core.data.local.QuranDatabase
import com.example.quran.core.data.local.SurahDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): QuranDatabase {
        return Room.databaseBuilder(
            context,
            QuranDatabase::class.java,
            "quran.db"
        )
            .createFromAsset("quran.db")
            .fallbackToDestructiveMigration(true)
            .build()
    }

    @Singleton
    @Provides
    fun provideSurahDao(db: QuranDatabase): SurahDao = db.surahDao()
}