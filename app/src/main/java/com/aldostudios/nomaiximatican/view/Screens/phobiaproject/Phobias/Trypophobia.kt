package com.aldostudios.nomaiximatican.view.Screens.phobiaproject.Phobias

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.aldostudios.nomaiximatican.ui.theme.NomaiximaticanTheme
import androidx.lifecycle.viewmodel.compose.viewModel
//Para llamar al viewmodel
import com.aldostudios.nomaiximatican.viewmodel.PhobiasViewModel.TrypophobiaVM

@Composable
fun Trypophobia(
    TryphobiaVM: TrypophobiaVM = viewModel(),
    onNavigateTryresults: () -> Unit,
    onBack: () -> Unit
    ) {
    // UI
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Asistencia para Tripofobia",
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            //En que nivel de exposion está el usuario
                                            //llamar al VW.funcion a llamar
            text = "Nivel de exposicion : ${TryphobiaVM.numberset}"
        )
        //Nombre de la imagen
        Text(
            text = "${TryphobiaVM.photoname}"
        )
        Text(
            text = "¿Cómo te hace sentir esta imagen?"
        )
        //Good
        Button(
            onClick = onNavigateTryresults,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFAEFFBE),
                contentColor = Color(0xFF00B224)
            )
        ) {
            Text("Lo tolero bien")
        }
        //Meh
        Button(
            onClick = onNavigateTryresults,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFFEFC2),
                contentColor = Color(0xFFFFC300)
            )
        ) {
            Text("Me incomoda")
        }
        //Bad
        Button(
            onClick = onNavigateTryresults,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFFCACA),
                contentColor = Color(0xFFFF0000)
            )
        ) {
            Text("Me da repulsión")
        }
        // Botón para regresar al selector de fobias
        Button(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFFFFFF),
                contentColor = MaterialTheme.colorScheme.primary
            )
        ) {
            Text(
                text = "Regresar a las fobias",
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TrypophobiaPreview() {
    NomaiximaticanTheme {
        Trypophobia(onNavigateTryresults = {}, onBack = {})
    }
}