package com.albertomier.lotterygenerator.main.components

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun Toast() {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 44.dp)
    ) {
        Spacer(modifier = Modifier.height(24.dp))

        val context = LocalContext.current
        Button(modifier = Modifier.fillMaxWidth(),
            onClick = {
                Toast
                    .makeText(context, "Toast message", Toast.LENGTH_SHORT)
                    .show()
            }
        ) {
            Text(text = "Simple toast")
        }
    }

}