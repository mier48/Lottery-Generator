package com.albertomier.lotterygenerator.main.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.albertomier.lotterygenerator.home.ui.viewmodel.HomeViewModel
import com.albertomier.lotterygenerator.main.navigation.MyAppNavHost
import com.albertomier.lotterygenerator.theme.ComposeUIKitTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeUIKitTheme {
                MyAppNavHost(viewModel = homeViewModel)
            }
        }
    }
}