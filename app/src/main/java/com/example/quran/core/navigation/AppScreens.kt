package com.example.quran.core.navigation

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.annotation.ExperimentalVoyagerApi
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.NavigatorDisposeBehavior
import cafe.adriel.voyager.transitions.SlideTransition
import com.example.quran.Routes

@OptIn(ExperimentalVoyagerApi::class)
@Composable
fun AppScreens() {
    val initialScreen = Routes.surahList()

    Navigator(
        screen = initialScreen,
        disposeBehavior = NavigatorDisposeBehavior(disposeSteps = true)
    ) { navigator ->
        SlideTransition(
            navigator = navigator,
            disposeScreenAfterTransitionEnd = true
        )
    }
}