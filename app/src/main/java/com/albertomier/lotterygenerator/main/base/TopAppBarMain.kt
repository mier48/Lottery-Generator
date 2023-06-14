@file:OptIn(ExperimentalMaterial3Api::class)

package com.albertomier.lotterygenerator.main.base

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.albertomier.lotterygenerator.R
import com.albertomier.lotterygenerator.theme.Typography

@Composable
fun TopAppBarMain() {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color.White),
        title = {
            Text(
                text = stringResource(id = R.string.app_name),
                color = MaterialTheme.colorScheme.primary,
                style = Typography.titleLarge
            )
        },
    )
}