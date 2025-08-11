package com.example.cptracker.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.cptracker.R

val latoFontFamily = FontFamily(
    Font(R.font.lato_light, FontWeight.Light),
    Font(R.font.lato_semibold, FontWeight.SemiBold),
    Font(R.font.lato_bold, FontWeight.Bold)
)

val AppTypography = Typography(
    displayLarge = TextStyle(
        fontFamily = latoFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 40.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = latoFontFamily,
        fontWeight = FontWeight.Light,
        fontSize = 20.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = latoFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp
    ),
    labelSmall = TextStyle(
        fontFamily = latoFontFamily,
        fontWeight = FontWeight.Light,
        fontSize = 14.sp
    ),
    labelLarge = TextStyle(
        fontFamily = latoFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp
    ),
    titleSmall = TextStyle(
        fontFamily = latoFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp
    ),
    displayMedium = TextStyle(
        fontFamily = latoFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 46.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = latoFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = latoFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = latoFontFamily,
        fontWeight = FontWeight.Light,
        fontSize = 18.sp
    ),
    bodySmall = TextStyle(
        fontFamily = latoFontFamily,
        fontWeight = FontWeight.Light,
        fontSize = 12.sp
    ),
    titleMedium = TextStyle(
        fontFamily = latoFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp
    )
)

private val LightColorScheme = lightColorScheme(
    primary = LightPrimary,
    primaryContainer = LightPrimaryVariant,
    background = LightBackground,
    surface = LightSurface,
    onPrimary = LightOnPrimary,
    onBackground = LightOnBackground
)

private val DarkColorScheme = darkColorScheme(
    primary = DarkPrimary,
    primaryContainer = DarkPrimaryVariant,
    background = DarkBackground,
    surface = DarkSurface,
    onPrimary = DarkOnPrimary,
    onBackground = DarkOnBackground
)

@Composable
fun CPTrackerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colors,
        typography = AppTypography,
        shapes = Shapes(),
        content = content
    )
}
