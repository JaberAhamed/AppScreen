package org.mj.appscreens.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

object CustomColor {
    val orange = Color(0xFFFF7A30)
    val green = Color(0xFF25493A)
    val deepGray = Color(0xFF07635D)
    val pestColor = Color(0xFFF1F4FF)
    val lightGray = Color(0xFFECECEC)
    val lightSky = Color(0xFFD3E7FC)
    val lightBrown = Color(0xFFF7E1E9)
    val blue = Color(0xFFD0E3F3)
    val purple_500 = Color(0xFF2D3466)
    val purple_100 = Color(0xFF7785F2)
    val purple_200 = Color(0xFF49506D)
    val purple_400 = Color(0xFF4A4452)
    val purple_600 = Color(0xFF2C2E55)
    val crayon_500 = Color(0xFF93225B)
    val crayon_600 = Color(0xFF545F87)
    val brown_600 = Color(0xFF2F305F)

    val purple_50 = Color(0xFF4D5575)
    val purple_70 = Color(0x953E4064)
    val purple_80 = Color(0x2F3E4063)
}

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
     */
)

@Composable
fun AppScreensTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
