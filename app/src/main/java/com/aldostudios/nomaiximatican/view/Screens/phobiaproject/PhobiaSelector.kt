package com.aldostudios.nomaiximatican.view.Screens.phobiaproject

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.aldostudios.nomaiximatican.ui.theme.NomaiximaticanTheme

@Composable
fun Selector(
    onNavigateTrypophobia: () -> Unit,
    onBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //Buton de Cerrar sesión y con colores propios
        Button(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFFCACA),
                contentColor = Color(0xFFFF0000)
            )
        ) {
            Text(
                text = "Cerrar sesión",
                style = MaterialTheme.typography.headlineMedium
            )
        }
        Text(
            text = "Seleccione su miedo",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.tertiary
        )
        //Buton para elegir Tripofobia y con colores ya establecidos
        Button(
            onClick = onNavigateTrypophobia,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.tertiary
            )
        ) {
            Text(
                text = "Tripofobia",
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SelectorPreview() {
    NomaiximaticanTheme {
        Selector(onNavigateTrypophobia = {}, onBack = {})
    }
}
