package com.example.ej03_components

import android.widget.Button
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.unit.dp


@Composable
fun MyProgress(modifier: Modifier.Companion) {
    var showLoading by rememberSaveable { mutableStateOf(true) }
    Column(
        Modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment =  Alignment.CenterHorizontally){

        if(showLoading){
            CircularProgressIndicator(
                color = Color.Red,
                strokeWidth = 4.dp
            )
            LinearProgressIndicator(
                modifier = Modifier.padding(top = 32.dp),
                color = Color.Red,
                trackColor = Color.Green
            )
        }
       Button(onClick = {showLoading =! showLoading}) {
           Text(text = "Cargar perfil...")
       }

    }
}
@Composable
fun MyProgressAdvance(){
    var progressStatus by rememberSaveable { mutableStateOf(0f) }
    Column (
        Modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment =  Alignment.CenterHorizontally
    ){
        LinearProgressIndicator(
            progress = {progressStatus}
        )
        Row(
            Modifier
                .padding(24.dp)
                .fillMaxSize()
        ){
            Button(onClick = {progressStatus += 0.1f}) {
                Text(text = "Sumar")
            }
        }
    }
}