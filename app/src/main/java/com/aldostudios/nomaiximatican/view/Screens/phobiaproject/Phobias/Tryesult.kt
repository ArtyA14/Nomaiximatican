package com.aldostudios.nomaiximatican.view.Screens.phobiaproject.Phobias

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Redo
import androidx.compose.material.icons.filled.SettingsBackupRestore
import androidx.compose.material.icons.filled.TransitEnterexit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aldostudios.nomaiximatican.ui.theme.NomaiximaticanTheme
import com.aldostudios.nomaiximatican.viewmodel.PhobiasViewModel.TrypophobiaVM

@Composable
fun Tryesult(
    TryphobiaVM: TrypophobiaVM = viewModel(),
    onNavigateSelector: () -> Unit,
    onBack: () -> Unit
){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Título de la pantalla
            Text(
                text = "Sesión completa",
                color = MaterialTheme.colorScheme.tertiary,
                style = MaterialTheme.typography.displayMedium.copy(
                    shadow = Shadow(
                        color = Color.Black.copy(alpha = 0.5f),
                        offset = Offset(4f, 4f),
                        blurRadius = 8f
                    )
                ),
                textAlign = TextAlign.Center
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(elevation = 5.dp, shape = RoundedCornerShape(20.dp))
                    .background(
                        color = Color(0xFFC9A15B),
                        shape = RoundedCornerShape(15.dp)
                    )
                    .padding(24.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Nivel de exposion: ${TryphobiaVM.numberset}",
                        color = MaterialTheme.colorScheme.tertiary,
                        style = MaterialTheme.typography.titleMedium.copy(
                            shadow = Shadow(
                                color = Color.Black.copy(alpha = 0.5f),
                                offset = Offset(4f, 4f),
                                blurRadius = 8f
                            )
                        ),
                        textAlign = TextAlign.Center
                    )
                    //Resultado de IA
                    //Boton de IA
                }
            }
            Spacer(Modifier.height(12.dp))
            // Botón para volver a intentar el test
            Button(
                onClick = onBack,
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .height(56.dp)
                    .shadow(elevation = 4.dp, shape = RoundedCornerShape(10.dp)),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.tertiary
                )
            ) {
                Icon(
                    imageVector = Icons.Default.SettingsBackupRestore,
                    contentDescription = "Volver a intentarlo",
                    tint = MaterialTheme.colorScheme.tertiary,
                    modifier = Modifier.padding(end = 8.dp)
                )
                Text(
                    text = "Volver a intentarlo",
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Center
                )
            }
            Spacer(Modifier.height(12.dp))

            //Botón para volver al selector de fobias
            Button(
                onClick = onNavigateSelector,
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .height(56.dp)
                    .shadow(elevation = 4.dp, shape = RoundedCornerShape(10.dp)),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.tertiary,
                    contentColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Icon(
                    imageVector = Icons.Default.ExitToApp,
                    contentDescription = "selector",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(end = 8.dp)
                )
                Text(
                    text = "Regresar a las fobias",
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Center
                )
            }



        }
    }
}@androidx.compose.ui.tooling.preview.Preview(showBackground = true, showSystemUi = true)
@Composable
fun TryesultPreview() {
    NomaiximaticanTheme {
        Tryesult(
            onNavigateSelector = {},
            onBack = {}
        )
    }
}

    // UI for Trypophobia Results
