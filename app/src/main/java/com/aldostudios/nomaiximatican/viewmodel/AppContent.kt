package com.aldostudios.nomaiximatican.viewmodel

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import com.aldostudios.nomaiximatican.view.Screens.phobiaproject.Home.Login
import com.aldostudios.nomaiximatican.view.Screens.phobiaproject.Home.Create
import com.aldostudios.nomaiximatican.view.Screens.phobiaproject.Home.Welcome
import com.aldostudios.nomaiximatican.view.Screens.phobiaproject.Selector
import com.aldostudios.nomaiximatican.view.Screens.phobiaproject.Phobias.Trypophobia
import com.aldostudios.nomaiximatican.view.Screens.phobiaproject.Phobias.Tryresult

sealed class Pantalla {
    object Login : Pantalla()
    object CreateAccount : Pantalla()
    object Welcome : Pantalla()
    object PhobiaSelector : Pantalla()
    object Trypophobia : Pantalla() //Fobia a los agujeros
    object arachnophobia //Fobia arácnida
    object ophidiophobia //Fobia a las serpientes
    object hypsophobia //Fobia a las alturas
    object seismophobia //Fobia al sismo
    object TrypophobiaResults : Pantalla()
    //object ArView : Pantalla()
}

@Composable
fun AppContent() {
    //val arViewModel = remember { ArViewModel() }
                                                               //Aqui se escoje cual pantalla va ir primero.
    var pantallaActual by remember { mutableStateOf<Pantalla>(Pantalla.Login) }

    when (pantallaActual) {
        Pantalla.Login -> Login(
            onNavigateSelector = { pantallaActual = Pantalla.PhobiaSelector },
            onNavigateCreate = { pantallaActual = Pantalla.CreateAccount }
            //onNavigateAr = { pantallaActual = Pantalla.ArView }
        )
        Pantalla.CreateAccount -> Create(
            onNavigate = { pantallaActual = Pantalla.Welcome },
            onBack = { pantallaActual = Pantalla.Login}
        )

        Pantalla.Welcome -> Welcome(
            onNavigateSelector = { pantallaActual = Pantalla.PhobiaSelector }
        )

        Pantalla.PhobiaSelector -> Selector(
            onNavigateTrypophobia = { pantallaActual = Pantalla.Trypophobia },
            onBack = { pantallaActual = Pantalla.Login }
        )

        Pantalla.Trypophobia -> Trypophobia(
            onBack = { pantallaActual = Pantalla.PhobiaSelector },
            onNavigateTryresults = { pantallaActual = Pantalla.TrypophobiaResults }
        )

        Pantalla.TrypophobiaResults -> Tryresult(
            onBack = { pantallaActual = Pantalla.Trypophobia},
            onNavigateSelector = { pantallaActual = Pantalla.PhobiaSelector}
        )

        Pantalla.arachnophobia -> {}
        Pantalla.ophidiophobia -> {}
        Pantalla.hypsophobia -> {}
        Pantalla.seismophobia -> {}


        //Pantalla.ArView -> ArScreen(
            //(viewModel = arViewModel,
            //onBack = { pantallaActual = Pantalla.Login }
        //)
    }
}
