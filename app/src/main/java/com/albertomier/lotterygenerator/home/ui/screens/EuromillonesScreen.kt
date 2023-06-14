package com.albertomier.lotterygenerator.home.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.albertomier.lotterygenerator.R
import com.albertomier.lotterygenerator.home.ui.components.BoxNumber
import com.albertomier.lotterygenerator.home.ui.components.BoxTitle
import com.albertomier.lotterygenerator.home.ui.components.RoundedButton
import com.albertomier.lotterygenerator.home.ui.viewmodel.HomeViewModel
import com.albertomier.lotterygenerator.main.base.ShowProgressIndicator
import com.albertomier.lotterygenerator.main.components.DefaultImage

@Composable
fun EuromillonesScreen(viewModel: HomeViewModel) {
    val context = LocalContext.current
    var generated by remember { mutableStateOf(false) }

    val numbersList: List<Int> by viewModel.numbersList.observeAsState(initial = emptyList())
    val starsList: List<Int> by viewModel.starsList.observeAsState(initial = emptyList())
    val loading: Boolean by viewModel.loading.observeAsState(initial = false)

    Scaffold(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(12.dp)
            ) {
                DefaultImage(
                    drawable = R.drawable.euromillones_logo,
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.FillWidth
                )

                RoundedButton(text = "Generar") {
                    viewModel.generateEuromillonesNumbers()
                    generated = true
                }
            }

            Column(modifier = Modifier.fillMaxWidth()) {
                if (loading) {
                    ShowProgressIndicator()
                } else {
                    if (generated) {
                        NumbersLayout(numbersList)
                        StarsLayout(starsList)
                    }
                }
            }
        }
    }
}

@Composable
private fun NumbersLayout(numbersList: List<Int>) {
    BoxTitle(text = "Números")

    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(6.dp)
            .fillMaxWidth()
    ) {
        BoxNumber(text = "${numbersList[0]}")
        Spacer(modifier = Modifier.padding(6.dp))
        BoxNumber(text = "${numbersList[1]}")
        Spacer(modifier = Modifier.padding(6.dp))
        BoxNumber(text = "${numbersList[2]}")
        Spacer(modifier = Modifier.padding(6.dp))
        BoxNumber(text = "${numbersList[3]}")
        Spacer(modifier = Modifier.padding(6.dp))
        BoxNumber(text = "${numbersList[4]}")
    }
}

@Composable
fun StarsLayout(starsList: List<Int>) {
    BoxTitle(text = "Estrellas")

    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(6.dp)
            .fillMaxWidth()
    ) {
        BoxNumber(text = "${starsList[0]}")
        Spacer(modifier = Modifier.padding(6.dp))
        BoxNumber(text = "${starsList[1]}")
    }
}