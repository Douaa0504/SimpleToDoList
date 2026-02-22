package com.example.simpletodoapp.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable


// Palette inspirée de vos fichiers
val PrimaryTeal = Color(0xFF2BCDEE)
val BackgroundNude = Color(0xFFF9F5F0) // Le ton beige clair
val CharcoalSoft = Color(0xFF333333)   // Pour le texte principal
val MutedGray = Color(0xFF9BA6A8)      // Pour les textes secondaires
val NudeBeige = Color(0xFFE8DFD5)      // Pour les bordures ou cartes


private val DarkColorScheme = darkColorScheme(
    primary = PrimaryTeal,
    secondary = MutedGray,
    background = Color(0xFF101F22), // Version sombre
    surface = Color(0xFF1A2B2E),
    onPrimary = Color.White,
    onBackground = Color.White
)

private val LightColorScheme = lightColorScheme(
    primary = PrimaryTeal,
    secondary = NudeBeige,
    background = BackgroundNude, // Fond beige/nude du design
    surface = Color.White,
    onPrimary = Color.White,
    onBackground = CharcoalSoft,
    onSurface = CharcoalSoft
)

@Composable
fun SimpleToDoAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // On désactive souvent dynamicColor pour forcer NOTRE design personnalisé
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}