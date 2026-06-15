package com.aldostudios.nomaiximatican.viewmodel

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import com.aldostudios.nomaiximatican.model.CreateAccountModel

/**
 * [VIEWMODEL]
 * El ViewModel actúa como puente entre la Vista (UI) y el Modelo.
 * Mantiene el estado de la UI y reacciona a los eventos del usuario.
 */
class CreateVM : ViewModel() {

    // ESTADOS: Son privados para que solo el VM pueda cambiarlos (encapsulamiento)
    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    private val _errorMessage = mutableStateOf<String?>(null)
    val errorMessage: State<String?> = _errorMessage

    private val _isSuccess = mutableStateOf(false)
    val isSuccess: State<Boolean> = _isSuccess

    /**
     * Esta función es llamada por la Vista (UI).
     * Se encarga de validar y pedir al Modelo que haga el trabajo pesado.
     */
    fun createAccount(email: String, password: String, onSuccess: () -> Unit) {
        // 1. Validaciones previas
        if (email.isBlank() || password.isBlank()) {
            _errorMessage.value = "Por favor, completa todos los campos"
            return
        }

        if (password.length < 6) {
            _errorMessage.value = "La contraseña debe ser mayor a 6 caracteres"
            return
        }

        // 2. Iniciamos estado de carga y limpiamos errores anteriores
        _isLoading.value = true
        _errorMessage.value = null

        // 3. Llamamos al MODELO (CreateAccountModel)
        CreateAccountModel.performFirebaseSignUp(email, password) { success, error ->
            // Volvemos a ocultar el indicador de carga
            _isLoading.value = false

            if (success) {
                _isSuccess.value = true
                onSuccess() // Navegamos a la siguiente pantalla
            } else {
                // Si hubo error, actualizamos el estado para que la UI lo muestre
                _errorMessage.value = error
            }
        }
    }
    /**
     * Limpia el mensaje de error.
     */
    fun clearError() {
        _errorMessage.value = null
    }
}
