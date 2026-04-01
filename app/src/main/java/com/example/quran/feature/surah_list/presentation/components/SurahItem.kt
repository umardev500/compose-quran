package com.example.quran.feature.surah_list.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quran.core.ui.theme.Hafs
import com.example.quran.core.ui.theme.RC
import com.example.quran.core.ui.theme.RSC
import com.example.quran.core.util.clickableWithSound
import com.example.quran.domain.model.Surah

@Composable
fun SurahItem(
    surah: Surah,
    onClick: (surah: Surah) -> Unit = {},
    showDivider: Boolean = true
) {
    Column(
        modifier = Modifier
            .clickableWithSound {
                onClick(surah)
            }
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 12.dp, vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier
                    .weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text("${surah.index}.")
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    surah.tname?.let {
                        Text(
                            text = it,
                            fontFamily = RC,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Text(
                        text = "${surah.ename} | ${surah.ayas} Ayat",
                        fontFamily = RSC,
                        fontSize = 14.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }

            Spacer(modifier = Modifier.width(8.dp))

            surah.name?.let {
                Text(
                    text = it,
                    fontSize = 24.sp,
                    fontFamily = Hafs,
                )
            }
        }

        showDivider.takeIf { it }.let {
            HorizontalDivider()
        }
    }
}