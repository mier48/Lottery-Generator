package com.albertomier.lotterygenerator.home.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun DefaultButton(text: String, onButtonClick: () -> Unit) {
    Button(
        onClick = { onButtonClick() },
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text, color = Color.White)
    }
}

@Composable
fun RoundedButton(text: String, onButtonClick: () -> Unit) {
    Button(
        onClick = { onButtonClick() },
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(4.dp)
    ) {
        Text(text, color = Color.White)
    }
}