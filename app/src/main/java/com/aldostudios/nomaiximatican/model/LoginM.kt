package com.aldostudios.nomaiximatican.model

import com.google.firebase.auth.FirebaseAuth

object LoginModel {
    // Instancia de Firebase Auth
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    /**
     * Función para iniciar sesión en Firebase.
     * @param onResult Callback que devuelve un par (Éxito: Boolean, Mensaje: String?)
     */
    fun performFirebaseLogin(email: String, password: String, onResult: (Boolean, String?) -> Unit) {
        // Llamada asíncrona a Firebase para iniciar sesión
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Éxito
                    onResult(true, null)
                } else {
                    // Fallo con mensaje de error
                    val error = task.exception?.localizedMessage ?: "Error desconocido"
                    onResult(false, error)
                }
            }
    }
}
