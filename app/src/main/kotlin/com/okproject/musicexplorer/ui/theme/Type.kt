package com.okproject.musicexplorer.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight

import com.okproject.musicexplorer.R

val defaultFontFamily = FontFamily(
    Font(R.font.merriweather_black, FontWeight.Black),
    Font(R.font.merriweather_black_italic, FontWeight.Black, FontStyle.Italic),
    Font(R.font.merriweather_bold, FontWeight.Bold),
    Font(R.font.merriweather_bold_italic, FontWeight.Bold, FontStyle.Italic),
    Font(R.font.merriweather_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.merriweather_light, FontWeight.Light),
    Font(R.font.merriweather_light_italic, FontWeight.Light, FontStyle.Italic),
    Font(R.font.merriweather_regular, FontWeight.Normal)
)

val logoFontFamily = FontFamily(
    Font(R.font.rubik_vinyl_regular, FontWeight.Normal)
)

// Default Material 3 typography values
val baseline = Typography()

val AppTypography = Typography(
    displayLarge = baseline.displayLarge.copy(fontFamily = defaultFontFamily),
    displayMedium = baseline.displayMedium.copy(fontFamily = defaultFontFamily),
    displaySmall = baseline.displaySmall.copy(fontFamily = defaultFontFamily),
    headlineLarge = baseline.headlineLarge.copy(fontFamily = defaultFontFamily),
    headlineMedium = baseline.headlineMedium.copy(fontFamily = defaultFontFamily),
    headlineSmall = baseline.headlineSmall.copy(fontFamily = defaultFontFamily),
    titleLarge = baseline.titleLarge.copy(fontFamily = defaultFontFamily),
    titleMedium = baseline.titleMedium.copy(fontFamily = defaultFontFamily),
    titleSmall = baseline.titleSmall.copy(fontFamily = defaultFontFamily),
    bodyLarge = baseline.bodyLarge.copy(fontFamily = defaultFontFamily),
    bodyMedium = baseline.bodyMedium.copy(fontFamily = defaultFontFamily),
    bodySmall = baseline.bodySmall.copy(fontFamily = defaultFontFamily),
    labelLarge = baseline.labelLarge.copy(fontFamily = defaultFontFamily),
    labelMedium = baseline.labelMedium.copy(fontFamily = defaultFontFamily),
    labelSmall = baseline.labelSmall.copy(fontFamily = defaultFontFamily)
)

val CustomTypography = Typography(
    displayLarge = baseline.displayLarge.copy(fontFamily = logoFontFamily),
    displayMedium = baseline.displayMedium.copy(fontFamily = logoFontFamily),
    displaySmall = baseline.displaySmall.copy(fontFamily = logoFontFamily),
    headlineLarge = baseline.headlineLarge.copy(fontFamily = logoFontFamily),
    headlineMedium = baseline.headlineMedium.copy(fontFamily = logoFontFamily),
    headlineSmall = baseline.headlineSmall.copy(fontFamily = logoFontFamily),
    titleLarge = baseline.titleLarge.copy(fontFamily = logoFontFamily),
    titleMedium = baseline.titleMedium.copy(fontFamily = logoFontFamily),
    titleSmall = baseline.titleSmall.copy(fontFamily = logoFontFamily),
    bodyLarge = baseline.bodyLarge.copy(fontFamily = logoFontFamily),
    bodyMedium = baseline.bodyMedium.copy(fontFamily = logoFontFamily),
    bodySmall = baseline.bodySmall.copy(fontFamily = logoFontFamily),
    labelLarge = baseline.labelLarge.copy(fontFamily = logoFontFamily),
    labelMedium = baseline.labelMedium.copy(fontFamily = logoFontFamily),
    labelSmall = baseline.labelSmall.copy(fontFamily = logoFontFamily)
)
