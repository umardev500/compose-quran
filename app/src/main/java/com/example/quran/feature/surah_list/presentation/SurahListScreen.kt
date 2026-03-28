package com.example.quran.feature.surah_list.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getScreenModel
import com.example.quran.R
import com.example.quran.feature.surah_list.presentation.components.SurahItem

class SurahListScreen : Screen {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        val screenModel = getScreenModel<SurahListViewModel>()
        val surahs by screenModel.surahs.collectAsState()

        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text("Quran")
                    },
                    actions = {
                        IconButton(onClick = {}) {
                            Icon(
                                painter = painterResource(R.drawable.round_search_24),
                                contentDescription = "search icon",
                                modifier = Modifier
                                    .size(24.dp)
                            )
                        }
                        IconButton(onClick = {}) {
                            Icon(
                                painter = painterResource(R.drawable.more_vert_24dp),
                                contentDescription = "search icon",
                                modifier = Modifier
                                    .size(24.dp)
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
                items(surahs, key = { it.index }) {
                    SurahItem(surah = it)
                }
            }
        }
    }

}