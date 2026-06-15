package com.aldostudios.nomaiximatican.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.aldostudios.nomaiximatican.viewmodel.AppContent

class MainActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //Colores de la aplicación
            MaterialTheme(
                colorScheme = lightColorScheme(
                    background = Color(0xFFE8D8C3),
                    primary = Color(0xFF6B4F3A),
                    secondary = Color(0xFFC9A15B),
                    tertiary = Color(0XFFFFFFFF)
                )
            ) {
                //hacer que ocupe toda la pantalla la app
                Surface(
                    modifier = Modifier.Companion.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppContent()
                }

            }
        }
    }
}