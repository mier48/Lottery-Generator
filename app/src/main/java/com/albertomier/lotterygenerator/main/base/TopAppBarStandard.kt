@file:OptIn(ExperimentalMaterial3Api::class)

package com.albertomier.lotterygenerator.main.base

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.albertomier.lotterygenerator.R
import com.albertomier.lotterygenerator.theme.Typography

@Composable
fun TopAppBarStandard(
    navHostController: NavHostController,
    title: String
) {
    TopAppBar(
        title = {
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = title,
                style = Typography.titleMedium,
                color = MaterialTheme.colorScheme.onBackground
            )
        },
        navigationIcon = {
            IconButton(onClick = {
                navHostController.navigateUp()
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_left_arrow),
                    contentDescription = "Back button",
                    modifier = Modifier.size(22.dp),
                    tint = MaterialTheme.colorScheme.onBackground
                )
            }
        }
    )
}