package com.albertomier.lotterygenerator.splash.ui.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.albertomier.lotterygenerator.core.utils.AppThemeState
import com.albertomier.lotterygenerator.core.utils.SystemUiController
import com.albertomier.lotterygenerator.main.view.MainActivity
import com.albertomier.lotterygenerator.theme.appBarDarkBlackDark
import com.albertomier.lotterygenerator.theme.appScaffoldColor
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay

@SuppressLint("CustomSplashScreen")
class SplashActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val splashScreen = installSplashScreen()
            splashScreen.setKeepOnScreenCondition { true }
        }
        super.onCreate(savedInstanceState)

        setContent {
            val systemUiController = remember { SystemUiController(window) }
            val appTheme = remember { mutableStateOf(AppThemeState()) }
            val appThemeState = appTheme.value

            systemUiController.setStatusBarColor(
                color = if (appThemeState.darkTheme) appBarDarkBlackDark else appScaffoldColor,
                darkIcons = !appThemeState.darkTheme
            )
        }

        lifecycleScope.launchWhenCreated {
            delay(1000)

            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}