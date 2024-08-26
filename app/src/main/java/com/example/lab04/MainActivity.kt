package com.example.lab04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab04.ui.theme.Lab04Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab04Theme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting( modifier: Modifier = Modifier) {
    ListaNombres(listOf("Juan", "Pedro", "Maria", "Ana", "Luis"))
}
@Composable
fun ListaNombres(nombres: List<String>) {
    LazyColumn(
        modifier = Modifier.padding(16.dp)
    ) {
        // items es una función que permite iterar sobre la lista de nombres
        items(nombres) { nombre ->
            ItemNombre(nombre)
        }
    }
}

@Composable
fun ItemNombre(nombre: String) {
    Text(
        text = nombre,
        modifier = Modifier.padding(8.dp)
    )
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab04Theme {
        Greeting()
    }
}