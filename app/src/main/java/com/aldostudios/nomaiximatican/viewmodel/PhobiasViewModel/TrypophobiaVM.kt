package com.aldostudios.nomaiximatican.viewmodel.PhobiasViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
// Importamos el modelo para obtener los datos
import com.aldostudios.nomaiximatican.model.Phobiasmodel.TrypohobiaM

/**
 * [VIEWMODEL]
 * Actúa como intermediario entre el Modelo (datos) y la Vista (pantalla).
 * Gestiona el estado de la UI y la lógica de negocio.
 */
class TrypophobiaVM : ViewModel() {
    // Estado observable para el nivel de exposición (obtenido del modelo)
    var numberset by mutableStateOf(TrypohobiaM.set)
    
    // Estado observable para el nombre de la foto (obtenido del modelo)
    var photoname by mutableStateOf(TrypohobiaM.name)
    
    // Estado observable para el ID de la imagen (obtenido del modelo)
    var imageResId by mutableStateOf(TrypohobiaM.imageResId)
    
    // Estado de la UI: Indica si la imagen debe estar censurada (con blur) o no
    var isBlurred by mutableStateOf(true)

    /**
     * Función que cambia el estado del desenfoque.
     * Si está borroso lo aclara, y viceversa.
     */
    fun toggleBlur() {
        isBlurred = !isBlurred
    }
}
