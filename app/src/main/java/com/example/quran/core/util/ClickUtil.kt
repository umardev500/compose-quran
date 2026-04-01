package com.example.quran.core.util

import android.view.SoundEffectConstants
import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.platform.LocalView

@Composable
fun Modifier.clickableWithSound(
    enabled: Boolean = true,
    onClick: () -> Unit
): Modifier {
    val view = LocalView.current

    return this.clickable(enabled = enabled) {
        if (enabled && view.isSoundEffectsEnabled) {
            view.playSoundEffect(SoundEffectConstants.CLICK)
        }
        onClick()
    }
}

@Composable
fun clickWithSound(
    onClick: () -> Unit
): () -> Unit {
    val view = LocalView.current

    return {
        if (view.isSoundEffectsEnabled) {
            view.playSoundEffect(SoundEffectConstants.CLICK)
        }
        onClick()
    }
}