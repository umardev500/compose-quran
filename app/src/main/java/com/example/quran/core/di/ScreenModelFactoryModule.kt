package com.example.quran.core.di

import cafe.adriel.voyager.hilt.ScreenModelFactory
import cafe.adriel.voyager.hilt.ScreenModelFactoryKey
import com.example.quran.feature.surah_detail.presentation.SurahDetailViewModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoMap

@Module
@InstallIn(SingletonComponent::class)
abstract class ScreenModelFactoryModule {

    @Binds
    @IntoMap
    @ScreenModelFactoryKey(SurahDetailViewModel.Factory::class)
    abstract fun bindSurahDetailViewModelFactory(
        factory: SurahDetailViewModel.Factory
    ): ScreenModelFactory
}
