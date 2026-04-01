package com.example.quran.feature.surah_list.presentation.components

import android.content.ClipData
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ClipEntry
import androidx.compose.ui.platform.LocalClipboard
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quran.R
import com.example.quran.core.ui.theme.RR
import com.example.quran.core.util.clickableWithSound
import com.example.quran.domain.model.AyahWithTranslation
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SurahItemSheet(
    surah: String,
    ayah: AyahWithTranslation?,
    onDismissRequest: () -> Unit = {}
) {
    val clipboard = LocalClipboard.current
    val scope = rememberCoroutineScope()

    ModalBottomSheet(onDismissRequest = onDismissRequest) {
        Column(
            modifier = Modifier
                .padding(bottom = 16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp, horizontal = 16.dp),
                horizontalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = "QS. $surah: Ayat ${ayah?.aya}",
                    fontFamily = RR,
                    fontSize = 18.sp
                )
            }
            SurahItemSheetItem(
                title = "Bagikan Ayat",
                iconRes = R.drawable.share_24dp_fill
            )
            SurahItemSheetItem(
                title = "Salin Ayat",
                iconRes = R.drawable.content_copy_24dp,
                onClick = {
                    scope.launch {
                        val textToCopy = buildString {
                            append(ayah?.arabicText ?: "")
                            append("\n")
                            append(ayah?.translationText ?: "")
                        }

                        clipboard.setClipEntry(
                            ClipEntry(
                                ClipData.newPlainText(
                                    "Ayah",
                                    textToCopy
                                )
                            )
                        )
                    }
                }
            )
            SurahItemSheetItem(
                title = "Tambah ke Bookmark",
                iconRes = R.drawable.bookmark_add_24dp_fill
            )
            SurahItemSheetItem(
                title = "Tandai Terakhir Baca",
                iconRes = R.drawable.done_all_24dp_fill
            )
        }
    }
}

@Composable
fun SurahItemSheetItem(
    title: String,
    @DrawableRes iconRes: Int,
    onClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickableWithSound {
                onClick()
            }
            .padding(vertical = 16.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(iconRes),
            contentDescription = title
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = title,
            fontFamily = RR
        )
    }
}