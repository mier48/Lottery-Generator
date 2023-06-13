package com.albertomier.lotterygenerator.main.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.albertomier.lotterygenerator.home.ui.screens.BonolotoScreen
import com.albertomier.lotterygenerator.home.ui.screens.EuromillonesScreen
import com.albertomier.lotterygenerator.home.ui.screens.LaPrimitivaScreen
import com.albertomier.lotterygenerator.home.ui.viewmodel.HomeViewModel
import com.albertomier.lotterygenerator.main.navigation.Screens.Home
import com.albertomier.lotterygenerator.main.navigation.Screens.LaPrimitiva
import com.albertomier.lotterygenerator.main.navigation.Screens.Bonoloto

@Composable
fun BottomNavigation(
    modifier: Modifier = Modifier,
    bottomNavController: NavHostController,
    startDestination: String = Home.route,
    mainNavController: NavHostController,
    viewModel: HomeViewModel
) {
    NavHost(
        modifier = modifier,
        navController = bottomNavController,
        startDestination = startDestination,
        route = "bottomRoute"
    ) {
        composable(Home.route) { EuromillonesScreen(viewModel) }
        composable(LaPrimitiva.route) { LaPrimitivaScreen(viewModel) }
        composable(Bonoloto.route) { BonolotoScreen(viewModel) }
    }
}