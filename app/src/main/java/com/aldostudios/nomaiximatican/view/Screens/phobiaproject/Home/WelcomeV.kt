package com.aldostudios.nomaiximatican.view.Screens.phobiaproject.Home

import android.R
import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.DirectionsWalk
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.aldostudios.nomaiximatican.ui.theme.NomaiximaticanTheme

@Composable
fun Welcome(
    onNavigateSelector: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
            Text(
                text = "¿De que trata Nomaiximatican?",
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.height(20.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth(0.8f)//Ancho de la caja
                    .padding(1.dp)//espacio de la caja
                    .shadow(elevation = 10.dp)
                    .background(
                        color = Color(0xFFC9A15B),
                        shape = RoundedCornerShape(30.dp)
                    ),
                contentAlignment = Alignment.Center // 👈 centra el contenido
            ) {
                Text(
                    text = "Del Nahualt Noamaiximati, \n" +
                            "que significa \n" +
                            "autoconocimento y del can \n" +
                            "que significa lugar.\n" +
                            "Noamaiximatican significa\n" +
                            "Lugar de autoconocimiento.",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.tertiary,
                    textAlign = TextAlign.Center // 👈 centra el texto
                )
            }

            Spacer(Modifier.height(10.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .shadow(elevation = 10.dp)
                    .background(
                        color = Color(0xFF6B4F3A),
                        shape = RoundedCornerShape(12.dp)
                    ),
                contentAlignment = Alignment.Center // 👈 centra el contenido
            ) {
                Text(
                    text = "Noamaiximatican es una \n" +
                            "aplicacion para poder llevar \n" +
                            "un seguimiento y mejorar la \n" +
                            "respuesta del sujeto de \n" +
                            "alguna fobia en especifico",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.tertiary,
                    textAlign = TextAlign.Center
                )
            }

            Spacer(Modifier.height(10.dp))

            Button(
                onClick = onNavigateSelector,
                modifier = Modifier
                    .fillMaxWidth(0.57f)//Ancho del boton
                    .height(50.dp)//Largo del boton
                    .shadow(elevation = 3.dp),
                shape = (RoundedCornerShape(10.dp)),//Esquinas redondeadas del boton
                colors = ButtonDefaults.buttonColors(
                    // Color del boton
                    containerColor = MaterialTheme.colorScheme.tertiary,
                    // Color del texto
                    contentColor = MaterialTheme.colorScheme.secondary
                )
            ) {
                Icon( // hasta el final va el nombre del icono
                    imageVector = Icons.AutoMirrored.Filled.DirectionsWalk,
                    contentDescription = "Continuar",
                    tint = MaterialTheme.colorScheme.secondary
                )
                Text(
                    text = "Continuar",
                    style = MaterialTheme.typography.headlineMedium
                )
            }
        }
    }

// Para poder utilizar el preview
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun WelcomePreview() {
    // IMPORTANTE: Envolvemos con el tema para que el Preview use
    // tus colores (crema, café) y no los de Android por defecto.
    NomaiximaticanTheme {
        // Como el Preview no puede recibir funciones reales de navegación,
        // le pasamos bloques vacíos "{}" para que no marque error.
        Welcome(onNavigateSelector = {})
    }
}