package com.example.quran.core.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.quran.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

val Hafs = FontFamily(
    Font(R.font.hafs, FontWeight.Normal)
)

val RSC = FontFamily(
    Font(R.font.rsc, FontWeight.Normal)
)

val RC = FontFamily(
    Font(R.font.rc, FontWeight.Normal)
)

val RR = FontFamily(
    Font(R.font.rr, FontWeight.Normal)
)

val Bismillah = FontFamily(
    Font(R.font.bismillah, FontWeight.Normal)
)

val Qalammajeed3 = FontFamily(
    Font(R.font.qalammajeed3, FontWeight.Normal)
)

val Amiri = FontFamily(
    Font(R.font.amiri_regular, FontWeight.Normal)
)