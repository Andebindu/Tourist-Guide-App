package com.touristguide.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorPalette = lightColorScheme(
    primary = brown,
    secondary = brown,
    background = white
)

@Composable
fun TouristGuideAppTheme(content: @Composable () -> Unit) {

    MaterialTheme(
        colorScheme = LightColorPalette,
        typography = Typography(),
        shapes = Shapes(),
        content = content
    )

}