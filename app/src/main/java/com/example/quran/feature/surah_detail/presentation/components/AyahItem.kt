package com.example.quran.feature.surah_detail.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quran.core.ui.theme.Hafs
import com.example.quran.core.ui.theme.RR
import com.example.quran.core.util.NumberMapper
import com.example.quran.core.util.clickableWithSound
import com.example.quran.domain.model.AyahWithTranslation

@Composable
fun AyahItem(
    ayah: AyahWithTranslation,
    showDivider: Boolean = true,
    isOdd: Boolean = false,
    onClick: (AyahWithTranslation) -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                if (isOdd) MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.3f)
                else Color.Transparent
            )
            .clickableWithSound {
                onClick(ayah)
            }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Text(
                text = "${ayah.arabicText} ${NumberMapper.toArabic(ayah.aya)}",
                fontFamily = Hafs,
                fontSize = 28.sp,
                textAlign = TextAlign.Right,
                lineHeight = 45.sp
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp),
        ) {
            Text(
                text = "${ayah.aya}. ",
                fontFamily = RR,
                fontSize = 16.sp,
                textAlign = TextAlign.Left,
            )
            Text(
                text = "${ayah.translationText} ",
                fontFamily = RR,
                fontSize = 16.sp,
                textAlign = TextAlign.Left,
            )
        }

//        showDivider.takeIf { it }.let {
//            HorizontalDivider()
//        }
    }
}