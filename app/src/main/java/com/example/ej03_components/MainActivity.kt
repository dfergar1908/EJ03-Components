package com.example.ej03_components

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ej03_components.ui.theme.EJ03ComponentsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EJ03ComponentsTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
//            }
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(30.dp),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //AQUÍ SE PONE EL PROGRAMA A EJECUTAR:
                    CheckboxListExample()
                    //CheckBoxExample(modifier:Modifier)
                }
            }
        }
    }

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        EJ03ComponentsTheme {
            //Aqui se pone la vista previa de el programa que quieras.
            CheckboxListExample()
        }
    }
}