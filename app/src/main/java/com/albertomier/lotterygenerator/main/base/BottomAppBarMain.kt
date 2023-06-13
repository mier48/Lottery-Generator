@file:OptIn(ExperimentalMaterial3Api::class)

package com.albertomier.lotterygenerator.main.base

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.albertomier.lotterygenerator.R
import com.albertomier.lotterygenerator.main.navigation.Screens.Bonoloto
import com.albertomier.lotterygenerator.main.navigation.Screens.Home
import com.albertomier.lotterygenerator.main.navigation.Screens.LaPrimitiva

@Composable
fun BottomAppBarMain(
    navHostController: NavHostController,
    selectedItem: MutableState<Int>,
    currentRoute: String?
) {

    data class BottomAppBarItem(
        val route: String,
        val title: String,
        val icon: Int
    )

    fun navigate(route: String) {
        navHostController.backQueue.clear()
        navHostController.navigate(route)
    }

    val items = listOf(
        BottomAppBarItem(
            route = Home.route,
            icon = R.drawable.euromillones,
            title = "Euromillones"
        ),

        BottomAppBarItem(
            route = LaPrimitiva.route,
            icon = R.drawable.la_primitiva,
            title = "La Primitiva"
        ),

        BottomAppBarItem(
            route = Bonoloto.route,
            icon = R.drawable.bonoloto,
            title = "Bonoloto"
        ),

//        BottomAppBarItem(
//            route = ElGordo.route,
//            icon = R.drawable.ic_location,
//            title = "El Gordo"
//        )
    )
    BottomNavigation(elevation = 10.dp, backgroundColor = MaterialTheme.colors.background) {
        items.forEachIndexed { index, item ->
            BottomNavigationItem(
                icon = { Icon(painter = painterResource(item.icon), contentDescription = "") },
                label = { Text(text = item.title, style = MaterialTheme.typography.caption) },
                selected = (currentRoute == item.route),
                onClick = {
                    if (currentRoute != item.route) {
                        selectedItem.value = index
                        navigate(item.route)
                    }
                })
        }
    }
}