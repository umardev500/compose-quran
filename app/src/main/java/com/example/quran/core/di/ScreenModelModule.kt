package com.example.quran.core.di

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.hilt.ScreenModelKey
import com.example.quran.feature.surah_detail.presentation.SurahDetailViewModel
import com.example.quran.feature.surah_list.presentation.SurahListViewModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoMap

@Module
@InstallIn(SingletonComponent::class)
abstract class ScreenModelModule {

    @Binds
    @IntoMap
    @ScreenModelKey(SurahListViewModel::class)
    abstract fun bindSurahListViewModel(
        impl: SurahListViewModel
    ): ScreenModel

}