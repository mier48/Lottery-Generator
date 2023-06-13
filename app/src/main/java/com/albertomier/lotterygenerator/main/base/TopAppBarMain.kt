@file:OptIn(ExperimentalMaterial3Api::class)

package com.albertomier.lotterygenerator.main.base

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.albertomier.lotterygenerator.theme.appRedColor
import com.albertomier.lotterygenerator.theme.Typography

@Composable
fun TopAppBarMain() {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = appRedColor),
        title = {
            Text(text = "Lottery Generator", color = Color.White, style = Typography.titleLarge)
        },
    )
}