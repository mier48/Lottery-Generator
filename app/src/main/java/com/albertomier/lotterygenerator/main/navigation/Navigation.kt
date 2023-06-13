package com.albertomier.lotterygenerator.main.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.albertomier.lotterygenerator.home.ui.viewmodel.HomeViewModel
import com.albertomier.lotterygenerator.main.navigation.Screens.Main
import com.albertomier.lotterygenerator.main.screens.MainScreen

@Composable
fun MyAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Main.route,
    viewModel: HomeViewModel
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination,
        route = "mainRoute"
    ) {
        //composable(Splash.route) { SplashScreen(navController) }
        composable(Main.route) {
            MainScreen(navHostController = navController, viewModel = viewModel)
        }
    }
}