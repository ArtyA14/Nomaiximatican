package com.aldostudios.nomaiximatican.view.Screens.phobiaproject.Home

import android.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aldostudios.nomaiximatican.viewmodel.LoginVM

@Composable
fun Login(
    onNavigateCreate: () -> Unit,
    onNavigateSelector: () -> Unit,
    // Usamos viewModel() para obtener la instancia del LoginVM
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
        Text(text = "Nomaiximatican",
            style = MaterialTheme.typography.headlineMedium)

        Spacer(Modifier.height(32.dp))

        // Textos de inicio de sesión
        Text(text = "Iniciar sesión",
            style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(6.dp))
        Text(text = "Ingrese su correo electrónico\n" +
                "para iniciar sesión",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.tertiary
        )

        // Campo de Email
        OutlinedTextField(
            value = loginVM.email,
            onValueChange = { loginVM.email = it },
            label = { Text("Correo electrónico") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            singleLine = true
        )

        Spacer(Modifier.height(8.dp))

        // Campo de Contraseña
        OutlinedTextField(
            value = loginVM.password,
            onValueChange = { loginVM.password = it },
            label = { Text("Contraseña") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            singleLine = true
        )

        Spacer(Modifier.height(16.dp))

        // Si hay un mensaje (error), lo mostramos en rojo
        loginVM.message?.let {
            Text(text = it, color = Color.Red, modifier = Modifier.padding(bottom = 8.dp))
        }

        // Si está cargando mostramos un circulito, si no, los botones
        if (loginVM.isLoading) {
            CircularProgressIndicator()
        } else {
            // Botón de Iniciar Sesión
            Button(
                onClick = { loginVM.onLoginClick(
                    onSuccess = onNavigateSelector) },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF11131A),
                    contentColor = MaterialTheme.colorScheme.tertiary
                )
            ) {
                Text("Iniciar sesión")
            }

            Spacer(Modifier.height(8.dp))

            // Botón de Crear Cuenta
            Button(
                onClick = onNavigateCreate,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF11131A),
                    contentColor = MaterialTheme.colorScheme.tertiary
                )
            ) {
                Text("Crear cuenta")
            }
        }
    }
}
