package com.aldostudios.nomaiximatican.viewmodel.PhobiasViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
//llamar al modelo
import com.aldostudios.nomaiximatican.model.Phobiasmodel.TrypohobiaM

//Para que El Viewmodel pueda acceder al modelo
class TrypophobiaVM : ViewModel() {
    var numberset by mutableStateOf(TrypohobiaM.set)
    var photoname by mutableStateOf(TrypohobiaM.name)
}
