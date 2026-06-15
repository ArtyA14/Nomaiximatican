package com.aldostudios.nomaiximatican.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ArViewModel : ViewModel() {
    // We hold the path to the 3D model in assets.
    // Replace "model.glb" with your actual file name later.
    private val _modelPath = MutableStateFlow("model.glb")
    val modelPath: StateFlow<String> = _modelPath
}