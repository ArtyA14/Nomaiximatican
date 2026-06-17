package com.aldostudios.nomaiximatican.view.Screens.phobiaproject.Home

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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircleOutline
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.aldostudios.nomaiximatican.ui.theme.NomaiximaticanTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aldostudios.nomaiximatican.viewmodel.LoginVM

@Composable
fun Login(
    onNavigateCreate: () -> Unit,
    onNavigateSelector: () -> Unit,
    loginVM: LoginVM = viewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Título de la app
        Text(
            text = "Nomaiximatican",
            color = MaterialTheme.colorScheme.tertiary,
            style = MaterialTheme.typography.displaySmall.copy(
                shadow = Shadow(
                    color = Color.Black.copy(alpha = 0.5f),
                    offset = Offset(4f, 4f),
                    blurRadius = 8f
                )
            )
        )

        Spacer(Modifier.height(30.dp))

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
                // Textos de inicio de sesión
                Text(
                    text = "Iniciar sesión",
                    color = MaterialTheme.colorScheme.tertiary,
                    style = MaterialTheme.typography.headlineLarge.copy(
                        shadow = Shadow(
                            color = Color.Black.copy(alpha = 0.5f),
                            offset = Offset(4f, 4f),
                            blurRadius = 8f
                        )
                    ),
                    textAlign = TextAlign.Center
                )
                Spacer(Modifier.height(6.dp))
                Text(
                    text = "Ingrese su correo electrónico\npara iniciar sesión",
                    color = MaterialTheme.colorScheme.tertiary,
                    style = MaterialTheme.typography.titleLarge.copy(
                        shadow = Shadow(
                            color = Color.Black.copy(alpha = 0.5f),
                            offset = Offset(4f, 4f),
                            blurRadius = 8f
                        )
                    ),
                    textAlign = TextAlign.Center,
                )

                Spacer(Modifier.height(16.dp))

                // Campo de Email corregido para Material3
                OutlinedTextField(
                    value = loginVM.email,
                    onValueChange = { loginVM.email = it },
                    label = { Text("Correo electrónico") },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    singleLine = true,
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        cursorColor = Color(0xFFC9A15B),
                        focusedIndicatorColor = Color(0xFFC9A15B),
                        unfocusedIndicatorColor = Color.Gray,
                        focusedLabelColor = Color(0xFFC9A15B),
                        unfocusedLabelColor = Color.LightGray
                    )
                )

                Spacer(Modifier.height(8.dp))

                // Campo de Contraseña corregido para Material3
                OutlinedTextField(
                    value = loginVM.password,
                    onValueChange = { loginVM.password = it },
                    label = { Text("Contraseña") },
                    modifier = Modifier.fillMaxWidth(),
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    singleLine = true,
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        cursorColor = Color(0xFFC9A15B),
                        focusedIndicatorColor = Color(0xFFC9A15B),
                        unfocusedIndicatorColor = Color.Gray,
                        focusedLabelColor = Color(0xFFC9A15B),
                        unfocusedLabelColor = Color.LightGray
                    )
                )

                Spacer(Modifier.height(16.dp))

                // Si hay un mensaje (error), lo mostramos en rojo
                loginVM.message?.let {
                    Text(text = it, color = Color.Red, modifier = Modifier.padding(bottom = 8.dp))
                }

                // Si está cargando mostramos un circulito, si no, los botones
                if (loginVM.isLoading) {
                    CircularProgressIndicator(color = MaterialTheme.colorScheme.tertiary)
                } else {

                    Spacer(Modifier.height(10.dp))

                    // Botón de Iniciar Sesión
                    Button(
                        onClick = {
                            loginVM.onLoginClick(
                                onSuccess = onNavigateSelector
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth(0.65f)
                            .height(56.dp)
                            .shadow(elevation = 4.dp, shape = RoundedCornerShape(10.dp)),
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF11131A),
                            contentColor = MaterialTheme.colorScheme.tertiary
                        )
                    ) {
                        Icon(
                            imageVector = Icons.Default.ChevronRight,
                            contentDescription = "Iniciar sesión",
                            tint = MaterialTheme.colorScheme.tertiary,
                            modifier = Modifier.padding(end = 8.dp)
                        )
                        Text(
                            "Iniciar sesión",
                            style = MaterialTheme.typography.titleMedium
                        )
                    }

                    Spacer(Modifier.height(8.dp))

                    Text(
                        text = "O puedes",
                        color = MaterialTheme.colorScheme.tertiary,
                        style = MaterialTheme.typography.titleMedium.copy(
                            shadow = Shadow(
                                color = Color.Black.copy(alpha = 0.5f),
                                offset = Offset(4f, 4f),
                                blurRadius = 8f
                            )
                        ),
                        textAlign = TextAlign.Center,
                    )

                    Spacer(Modifier.height(8.dp))

                    // Botón de Crear Cuenta
                    Button(
                        onClick = onNavigateCreate,
                        modifier = Modifier
                            .fillMaxWidth(0.65f)
                            .height(56.dp)
                            .shadow(elevation = 4.dp, shape = RoundedCornerShape(10.dp)),
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF11131A),
                            contentColor = MaterialTheme.colorScheme.tertiary
                        )
                    ) {
                        Icon(
                            imageVector = Icons.Default.AddCircleOutline,
                            contentDescription = "Crear cuenta",
                            tint = MaterialTheme.colorScheme.tertiary,
                            modifier = Modifier.padding(end = 8.dp)
                        )
                        Text(
                            "Crear cuenta",
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }

            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginPreview() {
    NomaiximaticanTheme {
        Login(onNavigateCreate = {}, onNavigateSelector = {})
    }
}
