package com.albertomier.lotterygenerator.main.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.albertomier.lotterygenerator.home.ui.viewmodel.HomeViewModel
import com.albertomier.lotterygenerator.main.base.BottomAppBarMain
import com.albertomier.lotterygenerator.main.base.TopAppBarMain
import com.albertomier.lotterygenerator.main.navigation.BottomNavigation
import com.albertomier.lotterygenerator.main.navigation.Screens.Home
import kotlinx.coroutines.launch

@Composable
fun MainScreen(
    navHostController: NavHostController,
    viewModel: HomeViewModel
) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)

    MainScreenContent(
        mainNavHostController = navHostController,
        drawerState = drawerState,
        viewModel = viewModel
    )
}

@Composable
fun GetTopAppBar(
    navHostController: NavHostController,
    drawerState: DrawerState,
    currentRoute: String?
) {
    val scope = rememberCoroutineScope()
    when (currentRoute) {
        Home.route -> {
            TopAppBarMain()
        }
//        Search.route -> {
//            TopAppBarSearch(navHostController = navHostController, searchHint = "Search Twitter")
//        }
//        Notifications.route -> {
//            TopAppBarStandard(navHostController = navHostController, title = "Notifications")
//        }
//        MessageList.route -> {
//            TopAppBarSearch(
//                navHostController = navHostController,
//                searchHint = "Search direct messages"
//            )
//        }
        else -> {
            TopAppBarMain()
        }
    }
}

@Composable
private fun MainScreenContent(
    mainNavHostController: NavHostController,
    drawerState: DrawerState,
    viewModel: HomeViewModel
) {
    val selectedItem = remember { mutableStateOf(0) }
    val bottomBarNavHostController = rememberNavController()
    val currentBottomRoute =
        bottomBarNavHostController.currentBackStackEntryFlow.collectAsState(initial = bottomBarNavHostController.currentBackStackEntry)

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            GetTopAppBar(
                navHostController = mainNavHostController,
                drawerState = drawerState,
                currentRoute = currentBottomRoute.value?.destination?.route
            )
        },
        bottomBar = {
            BottomAppBarMain(
                navHostController = bottomBarNavHostController,
                selectedItem = selectedItem,
                currentRoute = currentBottomRoute.value?.destination?.route
            )
        }
    ) { paddingValues ->
        Surface(
            shadowElevation = 9.dp,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            color = MaterialTheme.colorScheme.background
        ) {
            BottomNavigation(
                bottomNavController = bottomBarNavHostController,
                mainNavController = mainNavHostController,
                viewModel = viewModel
            )
        }
    }
}