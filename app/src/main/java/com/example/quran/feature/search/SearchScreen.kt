package com.example.quran.feature.search

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen

class SearchScreen : Screen {
    @Composable
    override fun Content() {
        Column() {
            Text(
                text = "Hello world"
            )
        }
    }

}