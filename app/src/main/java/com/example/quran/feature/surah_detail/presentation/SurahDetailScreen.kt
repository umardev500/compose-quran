package com.example.quran.feature.surah_detail.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.quran.R
import com.example.quran.core.util.clickWithSound
import com.example.quran.feature.surah_detail.presentation.components.AyahItem

data class SurahDetailScreen(val surahId: Int) : Screen {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        val screenModel =
            getScreenModel<SurahDetailViewModel, SurahDetailViewModel.Factory> { factory ->
                factory.create(surahId)
            }
        val ayahs by screenModel.ayahs.collectAsState()
        val navigator = LocalNavigator.currentOrThrow

        Scaffold(
            topBar = {
                TopAppBar(
                    navigationIcon = {
                        IconButton(onClick = clickWithSound { navigator.pop() }) {
                            Icon(
                                painter = painterResource(R.drawable.round_arrow_back_24),
                                contentDescription = "Back button"
                            )
                        }
                    },
                    title = {
                        Text(text = "Read Qur'an")
                    },
                    actions = {
                        IconButton(onClick = {}) {
                            Icon(
                                painter = painterResource(R.drawable.more_vert_24dp),
                                contentDescription = "More icon"
                            )
                        }
                    }
                )
            }
        ) { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                items(ayahs, key = { it.aya }) {
                    AyahItem(it)
                }
            }
        }
    }
}