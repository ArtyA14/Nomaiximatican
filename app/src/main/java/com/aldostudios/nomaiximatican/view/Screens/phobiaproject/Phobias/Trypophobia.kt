package com.aldostudios.nomaiximatican.view.Screens.phobiaproject.Phobias

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BackHand
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.SettingsBackupRestore
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aldostudios.nomaiximatican.R
import com.aldostudios.nomaiximatican.ui.theme.NomaiximaticanTheme
import androidx.lifecycle.viewmodel.compose.viewModel
// Importamos el ViewModel para conectar la lógica
import com.aldostudios.nomaiximatican.viewmodel.PhobiasViewModel.TrypophobiaVM

/**
 * [VISTA]
 * Define la interfaz de usuario para la pantalla de ayuda con la Tripofobia.
 * Muestra la imagen (censurada o no) y los botones de interacción.
 */
@Composable
fun Trypophobia(
    TryphobiaVM: TrypophobiaVM = viewModel(), // Instancia del ViewModel
    onNavigateTryresults: () -> Unit,           // Acción para ir a resultados
    onBack: () -> Unit                         // Acción para volver atrás
    ) {
    // Contenedor principal de la pantalla
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Título de la sección
        Text(
            text = "Asistencia para Tripofobia",
            color = MaterialTheme.colorScheme.tertiary,
            style = MaterialTheme.typography.displaySmall.copy(
                shadow = Shadow(
                    color = Color.Black.copy(alpha = 0.5f),
                    offset = Offset(4f, 4f),
                    blurRadius = 8f
                )
            ),
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(12.dp))
        
        // Tarjeta principal (el cuadro café)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(elevation = 5.dp, shape = RoundedCornerShape(20.dp))
                .background(
                    color = Color(0xFF6B4F3A),
                    shape = RoundedCornerShape(15.dp)
                )
                .padding(24.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                // Muestra el nivel de exposición actual desde el ViewModel
                Text(
                    text = "Nivel de exposicion : ${TryphobiaVM.numberset}",
                    color = MaterialTheme.colorScheme.tertiary,
                    style = MaterialTheme.typography.titleMedium.copy(
                        shadow = Shadow(
                            color = Color.Black.copy(alpha = 0.5f),
                            offset = Offset(4f, 4f),
                            blurRadius = 8f
                        )
                    ),
                    textAlign = TextAlign.Left
                )
                Spacer(Modifier.height(8.dp))
                
                // Muestra el nombre de la imagen desde el ViewModel
                Text(
                    text = "${TryphobiaVM.photoname}",
                    color = MaterialTheme.colorScheme.tertiary,
                    style = MaterialTheme.typography.titleLarge.copy(
                        shadow = Shadow(
                            color = Color.Black.copy(alpha = 0.5f),
                            offset = Offset(4f, 4f),
                            blurRadius = 8f
                        )
                    ),
                    textAlign = TextAlign.Center
                )
                Spacer(Modifier.height(8.dp))

                // [ÁREA DE IMAGEN CON CENSURA]
                Box(
                    modifier = Modifier
                        .size(250.dp)
                        .clip(RoundedCornerShape(15.dp))
                        .background(Color.Gray.copy(alpha = 0.2f))
                        // Al tocar el cuadro, el ViewModel cambia el estado del desenfoque
                        .clickable { TryphobiaVM.toggleBlur() },
                    contentAlignment = Alignment.Center
                ) {
                    // Carga la imagen definida en el Modelo a través del ViewModel
                    Image(
                        painter = painterResource(id = TryphobiaVM.imageResId),
                        contentDescription = "Imagen de prueba fobia",
                        modifier = Modifier
                            .fillMaxSize()
                            // Aplica desenfoque (blur) si isBlurred es verdadero
                            .blur(if (TryphobiaVM.isBlurred) 30.dp else 0.dp),
                        contentScale = ContentScale.Crop
                    )

                    // Capa visual que se muestra solo cuando la imagen está censurada
                    if (TryphobiaVM.isBlurred) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .background(Color.Black.copy(alpha = 0.5f), RoundedCornerShape(8.dp))
                                .padding(8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.VisibilityOff,
                                contentDescription = "Revelar",
                                tint = Color.White
                            )
                            Text(
                                text = "Toca para revelar",
                                color = Color.White,
                                style = MaterialTheme.typography.labelSmall
                            )
                        }
                    }
                }

                Spacer(Modifier.height(12.dp))
                Text(
                    text = "¿Cómo te hace sentir esta imagen?",
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
                Spacer(Modifier.height(12.dp))
                
                // BOTÓN: Lo tolero bien (Verde)
                Button(
                    onClick = onNavigateTryresults,
                    modifier = Modifier
                        .fillMaxWidth(0.65f)
                        .height(56.dp)
                        .shadow(elevation = 4.dp, shape = RoundedCornerShape(10.dp)),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFAEFFBE),
                        contentColor = Color(0xFF00B224)
                    )
                ) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = "Bien",
                        tint = Color(0xFF00B224),
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Text(
                        text = "Lo tolero bien",
                        style = MaterialTheme.typography.titleMedium,
                        textAlign = TextAlign.Center
                    )
                }
                Spacer(Modifier.height(12.dp))
                
                // BOTÓN: Me incomoda (Amarillo)
                Button(
                    onClick = onNavigateTryresults,
                    modifier = Modifier
                        .fillMaxWidth(0.65f)
                        .height(56.dp)
                        .shadow(elevation = 4.dp, shape = RoundedCornerShape(10.dp)),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFFEFC2),
                        contentColor = Color(0xFFFFC300)
                    )
                ) {
                    Icon(
                        imageVector = Icons.Default.BackHand,
                        contentDescription = "Meh",
                        tint = Color(0xFFFFC300),
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Text(
                        text = "Me incomoda",
                        style = MaterialTheme.typography.titleMedium,
                        textAlign = TextAlign.Center
                    )
                }
                Spacer(Modifier.height(12.dp))
                
                // BOTÓN: Me da repulsión (Rojo)
                Button(
                    onClick = onNavigateTryresults,
                    modifier = Modifier
                        .fillMaxWidth(0.65f)
                        .height(56.dp)
                        .shadow(elevation = 4.dp, shape = RoundedCornerShape(10.dp)),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFFCACA),
                        contentColor = Color(0xFFFF0000)
                    )
                ) {
                    Icon(
                        imageVector = Icons.Default.Cancel,
                        contentDescription = "Bad",
                        tint = Color(0xFFFF0000),
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Text(
                        text = "Me da repulsión",
                        style = MaterialTheme.typography.titleSmall,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
        Spacer(Modifier.height(12.dp))
        
        // Botón para regresar al selector de fobias
        Button(
            onClick = onBack,
            modifier = Modifier
                .fillMaxWidth(0.65f)
                .height(56.dp)
                .shadow(elevation = 4.dp, shape = RoundedCornerShape(10.dp)),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0XFFFFFFFF),
                contentColor = Color(0xFF6B4F3A)
            )
        ) {
            Icon(
                imageVector = Icons.Default.ExitToApp,
                contentDescription = "Return to Phobias",
                tint = Color(0xFF6B4F3A),
                modifier = Modifier.padding(end = 8.dp)
            )
            Text(
                text = "Regresar a las fobias",
                style = MaterialTheme.typography.titleSmall,
                textAlign = TextAlign.Center
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
