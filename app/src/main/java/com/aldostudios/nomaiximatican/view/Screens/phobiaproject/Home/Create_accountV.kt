package com.aldostudios.nomaiximatican.view.Screens.phobiaproject.Home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.aldostudios.nomaiximatican.ui.theme.NomaiximaticanTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aldostudios.nomaiximatican.viewmodel.CreateVM

@Composable
fun Create(
    onNavigate: () -> Unit,
    onBack: () -> Unit,
    // Inyectamos el CreateVM para que la vista pueda acceder a los estados y funciones.
    createVM: CreateVM = viewModel()
) {
    // Estados locales para los campos de texto (pertenecen solo a esta vista)
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    // Observamos los estados definidos en el ViewModel
    // Cuando estos valores cambien en el VM, Compose redibujará esta pantalla automáticamente.
    val isLoading by createVM.isLoading
    val errorMessage by createVM.errorMessage

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Crear Cuenta",
            style = MaterialTheme.typography.headlineLarge
        )
        Spacer(modifier = Modifier.height(32.dp))
        // Campo de texto para el Email
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Correo electrónico") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )
        Spacer(modifier = Modifier.height(16.dp))
        // Campo de texto para la Contraseña con transformación visual
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation(),
            singleLine = true
        )
        // Mostrar mensaje de error si existe
        errorMessage?.let {
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = it, color = Color.Red)
        }
        Spacer(modifier = Modifier.height(32.dp))
        // Botón de acción: Crear cuenta
        if (isLoading) {
            // Muestra un indicador de carga si la operación está en curso
            CircularProgressIndicator()
        } else {
            Button(
                onClick = {
                    // Llamamos a la función del ViewModel
                    createVM.createAccount(email, password) {
                        // Si tiene éxito, navegamos a la pantalla de Bienvenida
                        onNavigate()
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Crear cuenta")
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        // Botón para regresar al inicio
        Button(onClick = onBack) { Text("Ya estoy registrado. Regresar") }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CreatePreview() {
    NomaiximaticanTheme {
        Create(onNavigate = {}, onBack = {})
    }
}
