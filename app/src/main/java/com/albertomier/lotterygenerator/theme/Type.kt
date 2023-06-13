package com.albertomier.lotterygenerator.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.albertomier.lotterygenerator.R

val chirpFont = FontFamily(
    Font(R.font.chirp_regular),
    Font(R.font.chirp_bold, FontWeight.Bold),
    Font(R.font.chirp_heavy, FontWeight.ExtraBold),
    Font(R.font.chirp_medium, FontWeight.Medium),
)

// Set of Material typography styles to start with
val Typography = androidx.compose.material3.Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        letterSpacing = 0.4.sp,
        lineHeight = 20.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = chirpFont,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        letterSpacing = 0.4.sp,
        lineHeight = 18.sp,
    ),
    bodySmall = TextStyle(
        fontFamily = chirpFont,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        letterSpacing = 0.4.sp,
        lineHeight = 16.sp,
    ),
    headlineSmall = TextStyle(
        fontFamily = chirpFont,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 14.sp,
        letterSpacing = 0.5.sp,
        lineHeight = 20.sp,
    ),
    headlineMedium = TextStyle(
        fontFamily = chirpFont,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        letterSpacing = 0.5.sp,
        lineHeight = 24.sp,
    ),
    headlineLarge = TextStyle(
        fontFamily = chirpFont,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 22.sp,
        letterSpacing = 0.5.sp,
        lineHeight = 24.sp
    ),
    titleSmall = TextStyle(
        fontFamily = chirpFont,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 14.sp,
        letterSpacing = 0.4.sp,
        lineHeight = 16.sp
    ),
    titleMedium = TextStyle(
        fontFamily = chirpFont,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        letterSpacing = 0.4.sp,
        lineHeight = 24.sp
    ),
    titleLarge = TextStyle(
        fontFamily = chirpFont,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        letterSpacing = 0.4.sp,
        lineHeight = 24.sp
    ),
    labelLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        letterSpacing = 0.5.sp,
        lineHeight = 24.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        letterSpacing = 0.5.sp,
        lineHeight = 24.sp
    ),
)