package com.albertomier.lotterygenerator.main.navigation

sealed class Screens(val route: String) {
    object Splash : Screens("splash")
    object Home : Screens("home")
    object Main : Screens("main")
    object Euromillones : Screens("euromillones")
    object LaPrimitiva : Screens("la_primitiva")
    object Bonoloto : Screens("bonoloto")
    object ElGordo : Screens("el_gordo")
    object Settings : Screens("settings")
}