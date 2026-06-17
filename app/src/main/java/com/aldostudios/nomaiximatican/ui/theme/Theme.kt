package com.aldostudios.nomaiximatican.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.graphics.Color

// 1. Definimos nuestra paleta de colores personalizada
private val LightColorScheme = lightColorScheme(
    background = Color(0xFFE8D8C3), // Crema (Fondo de pantalla)
    primary = Color(0xFF6B4F3A),    // Café (Botones principales)
    secondary = Color(0xFFC9A15B),  // Dorado (Detalles)
    tertiary = Color(0XFFFFFFFF)    // Blanco (Texto sobre café o fondos oscuros)
)

@Composable
fun NomaiximaticanTheme(
    content: @Composable () -> Unit
) {
    // 2. Configuramos el proveedor del tema de Material 3
    MaterialTheme(
        colorScheme = LightColorScheme
    ) {
        // 3. Este 'Surface' es el truco mágico:
        // Hace que TODAS las pantallas que usen este tema tengan
        // el fondo crema y ocupen todo el espacio automáticamente.
        androidx.compose.material3.Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
            content = content
        )
    }
}