package com.albertomier.lotterygenerator.theme

import android.annotation.SuppressLint
import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.core.view.ViewCompat
import com.albertomier.lotterygenerator.ui.theme.Shapes
import com.albertomier.lotterygenerator.core.utils.TextColor.textPrimaryDarkColor
import com.albertomier.lotterygenerator.core.utils.TextColor.textPrimaryLightColor
import com.albertomier.lotterygenerator.core.utils.TextColor.textSecondaryDarkColor
import com.albertomier.lotterygenerator.core.utils.TextColor.textSecondaryLightColor
import com.albertomier.lotterygenerator.R

val aleoFontFamily = FontFamily(
    Font(R.font.aleo), // Regular
    Font(R.font.aleo_light, FontWeight.Light),
    Font(R.font.aleo_bold, FontWeight.Bold)
)

private val DarkColorScheme = darkColorScheme(
    primary = Black,
    surface = Black,
    primaryContainer = Black,
    secondary = ExtraLightGray,
    onSecondary = ExtraLightGray,
    tertiary = ExtraLightGray,
    onTertiary = ExtraLightGray,
    background = Black,
    onBackground = ExtraLightGray,
    onSurface = LightGray,
    secondaryContainer = DarkDarkGray
)

private val LightColorScheme = lightColorScheme(
    primary = appGreenColor,
    onPrimary = Black,
    secondary = White,
    tertiary = appGreenColor2,
    background = White,
    onBackground = Black,
    surface = White,
    secondaryContainer = ExtraExtraLightGray
)

@SuppressLint("ConflictingOnColor")
private val DarkRedColorPalette = darkColorScheme(
    primary = appRedColor,
    surface = appRedColor,
    onPrimary = textPrimaryDarkColor,
    onSecondary = textSecondaryDarkColor,
    onBackground = cardBackgroundBlackDark,
    secondary = cardBackgroundBlackDark,
    background = scaffoldDarkBlackDark
)

@SuppressLint("ConflictingOnColor")
private val LightRedColorPalette = lightColorScheme(
    primary = appRedColor,
    onPrimary = textPrimaryLightColor,
    onSecondary = textSecondaryLightColor,
    onBackground = appBackgroundColor,
    secondary = appLightGreyColor,
    background = appScaffoldColor

)

//@Composable
//fun LotteryGeneratorTheme(
//    darkTheme: Boolean = isSystemInDarkTheme(),
//    content: @Composable () -> Unit
//) {
//    val colors = if (darkTheme) {
//        DarkColorPalette
//    } else {
//        LightColorPalette
//    }
//
//    MaterialTheme(
//        colors = colors,
//        typography = Typography,
//        shapes = Shapes,
//        content = content
//    )
//}

@Composable
fun ComposeUIKitTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    statusBarColor: Color = LightColorScheme.tertiary,
    content: @Composable () -> Unit,
) {
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            (view.context as Activity).window.statusBarColor = statusBarColor.toArgb()
            ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography,
        content = content
    )
}

@Composable
fun ProkitJackComposeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    statusBarColor: Color = LightColorScheme.primary,
    content: @Composable () -> Unit,
) {
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            (view.context as Activity).window.statusBarColor = statusBarColor.toArgb()
            ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography,
        content = content
    )
}

@Composable
fun BaseView(content: @Composable () -> Unit) {
    ProkitJackComposeTheme(
        darkTheme = false,
        content = content
    )
}
