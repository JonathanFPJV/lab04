package com.example.lab04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab04.ui.theme.Lab04Theme
import androidx.compose.material3.Scaffold

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab04Theme {

                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    PantallaPrincipal()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaPrincipal() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Lista de Nombres") }

            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /* Acción del FAB */ }) {
                Text("+")
            }
        },
        content = { paddingValues ->
            // LazyColumn dentro de Scaffold
            ListaNombres(
                listOf("Juan", "Pedro", "Maria", "Ana", "Luis"),
                Modifier.padding(paddingValues) // Añade el padding del Scaffold
            )
        }
    )
}

@Composable
fun ListaNombres(nombres: List<String>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.padding(16.dp)
    ) {
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

@Preview(showBackground = true,
    showSystemUi = true
)
@Composable
fun PantallaPrincipalPreview() {
    Lab04Theme {
        PantallaPrincipal()
    }
}
