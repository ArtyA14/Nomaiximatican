package com.aldostudios.nomaiximatican.model

import com.google.firebase.auth.FirebaseAuth

object CreateAccountModel {
    // Instancia de Firebase Auth
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    /**
     * Función para crear cuenta en Firebase.
     * @param onResult Callback que devuelve un par (Éxito: Boolean, Mensaje: String?)
     */
    fun performFirebaseSignUp(email: String, password: String, onResult: (Boolean, String?) -> Unit) {
        // Llamada asíncrona a Firebase
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Notificamos éxito sin mensaje de error
                    onResult(true, null)
                } else {
                    // Notificamos fallo con el mensaje de la excepción
                    val error = task.exception?.localizedMessage ?: "Error desconocido"
                    onResult(false, error)
                }
            }
    }
}
