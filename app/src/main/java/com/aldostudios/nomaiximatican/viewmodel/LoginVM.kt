package com.aldostudios.nomaiximatican.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.aldostudios.nomaiximatican.model.LoginModel

/**
 * [VIEWMODEL]
 * El ViewModel sirve de puente entre el Modelo y la Vista.
 * Mantiene el estado de la UI y maneja la lógica de presentación.
 */
class LoginVM : ViewModel() {

    // Estado para el campo de email
    var email by mutableStateOf("")
    
    // Estado para el campo de contraseña
    var password by mutableStateOf("")

    // Estado para saber si estamos cargando (llamando a Firebase)
    var isLoading by mutableStateOf(false)

    // Estado para mostrar mensajes (errores o éxito)
    var message by mutableStateOf<String?>(null)

    /**
     * Función que se llama desde la Vista cuando el usuario pulsa "Iniciar sesión"
     * @param onSuccess Callback que se ejecuta si el login es correcto para navegar
     */
    fun onLoginClick(onSuccess: () -> Unit) {
        // Validamos que no estén vacíos (básico)
        if (email.isBlank() || password.isBlank()) {
            message = "Por favor, llena todos los campos"
            return
        }

        isLoading = true
        message = null

        // Llamamos al Modelo para realizar la operación de Firebase
        LoginModel.performFirebaseLogin(email, password) { success, error ->
            isLoading = false
            if (success) {
                // Si tuvo éxito, ejecutamos la navegación
                onSuccess()
            } else {
                // Si falló, guardamos el error para mostrarlo en la UI
                message = error
            }
        }
    }
}
