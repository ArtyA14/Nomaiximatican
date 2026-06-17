package com.aldostudios.nomaiximatican.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.aldostudios.nomaiximatican.ui.theme.NomaiximaticanTheme
import com.aldostudios.nomaiximatican.viewmodel.AppContent

class MainActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // 1. Envolvemos TODA la aplicación con nuestro tema personalizado.
            // Esto hace que los colores definidos en Theme.kt se apliquen a cada pantalla.
            NomaiximaticanTheme {

                // 2. Llamamos a AppContent, que es el que decide qué pantalla
                // mostrar (Login, Welcome, Selector, etc.) según la navegación.
                AppContent()
            }
        }
    }
}