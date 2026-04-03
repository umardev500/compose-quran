package com.example.quran.feature.surah_detail.presentation

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.quran.R
import com.example.quran.core.ui.theme.Bismillah
import com.example.quran.core.util.clickWithSound
import com.example.quran.domain.model.AyahWithTranslation
import com.example.quran.feature.surah_detail.presentation.components.AyahItem
import com.example.quran.feature.surah_list.presentation.components.SurahItemSheet

data class SurahDetailScreen(
    val surahId: Int,
    val surahName: String,
) : Screen {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        val screenModel =
            getScreenModel<SurahDetailViewModel, SurahDetailViewModel.Factory> { factory ->
                factory.create(surahId)
            }
        val ayahs by screenModel.ayahs.collectAsState()
        val navigator = LocalNavigator.currentOrThrow

        var showSheet by remember { mutableStateOf(false) }
        var selectedAyah by remember { mutableStateOf<AyahWithTranslation?>(null) }

        val onItemClick: (AyahWithTranslation) -> Unit = { ayah ->
            selectedAyah = ayah
            showSheet = true
        }

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
                        Text(text = surahName)
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
            // Bismillah

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                item {
                    if (surahId == 1) return@item
                    Spacer(Modifier.padding(top = 16.dp))
                    Text(
                        text = "5",
                        fontFamily = Bismillah,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    )
                }
                itemsIndexed(ayahs, key = { _, item -> item.aya }) { index, item ->
                    val isOdd = item.aya % 2 != 0

                    AyahItem(item, isOdd = isOdd, onClick = onItemClick)
                }
            }
        }

        if (showSheet) {
            SurahItemSheet(
                surah = surahName,
                ayah = selectedAyah,
                onDismissRequest = { showSheet = false })
        }
    }
}