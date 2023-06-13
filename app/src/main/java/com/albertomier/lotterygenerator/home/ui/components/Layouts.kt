package com.albertomier.lotterygenerator.home.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BoxNumber(text: String) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .border(
                border = ButtonDefaults.outlinedBorder,
                shape = RoundedCornerShape(4.dp)
            )
            .padding(12.dp)
    ) {
        Text(
            text = text,
            color = Color.DarkGray,
            style = MaterialTheme.typography.body1
        )
    }
}

@Composable
fun BoxTitle(text: String) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(6.dp)
            .fillMaxWidth(),
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(start = 8.dp),
            color = Color.DarkGray,
            style = MaterialTheme.typography.h5
        )
    }
}