package com.aldostudios.nomaiximatican.view

import android.Manifest
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import com.aldostudios.nomaiximatican.viewmodel.ArViewModel
import io.github.sceneview.ar.ARSceneView

@Composable
fun ArScreen(
    viewModel: ArViewModel,
    onBack: () -> Unit
) {
    val context = LocalContext.current

    // Permission state
    var hasPermission by remember {
        mutableStateOf(
            ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED
        )
    }

    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) {
        hasPermission = it
    }

    var arActivated by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        if (!hasPermission) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Se necesita permiso de cámara")
                Spacer(Modifier.height(16.dp))
                Button(onClick = { launcher.launch(Manifest.permission.CAMERA) }) {
                    Text("Conceder Permiso")
                }
            }
        } else if (!arActivated) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Listo para iniciar la cámara (V2)")
                Spacer(Modifier.height(16.dp))
                Button(onClick = { arActivated = true }) {
                    Text("Iniciar Cámara (Prueba)")
                }
            }
        } else {
            // Using AndroidView to wrap the V2 SceneView which is more stable
            AndroidView(
                modifier = Modifier.fillMaxSize(),
                factory = { ctx ->
                    ARSceneView(ctx).apply {
                        // Configuration for V2
                        planeRenderer.isVisible = true
                    }
                },
                update = { view ->
                    // Update logic here
                }
            )
        }

        Button(
            onClick = onBack,
            modifier = Modifier.align(Alignment.TopStart).padding(16.dp)
        ) {
            Text("Atrás")
        }
    }
}
