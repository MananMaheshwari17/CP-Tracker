package com.example.cptracker.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

@Composable
fun navBarGradient(): Brush {
    return if (isSystemInDarkTheme()) {
        Brush.linearGradient(
            colors = listOf(
                Color(0xCC00F1FF),
                Color(0xCC01BEC9)
            )
        )
    } else {
        Brush.linearGradient(
            colors = listOf(
                Color(0x6651E8F1),
                Color(0x4D31BAC2)
            )
        )
    }
}

@Composable
fun specialBoxGradient(): Brush {
    return if (isSystemInDarkTheme()) {
        Brush.linearGradient(
            colors = listOf(
                Color(0xCC00F1FF),
                Color(0xCC01BEC9)
            )
        )
    } else {
        Brush.linearGradient(
            colors = listOf(
                Color(0xCC00292B),
                Color(0xCC004D52)
            )
        )
    }
}
