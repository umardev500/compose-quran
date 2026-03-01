package com.example.quran.feature.surah_list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen

class SurahListScreen : Screen {
    @Composable
    override fun Content() {
        Scaffold { paddingValues ->
            Column(
                modifier = Modifier.padding(paddingValues)
            ) {
                Text(
                    text = "Hello from surah list"
                )
            }
        }
    }

}