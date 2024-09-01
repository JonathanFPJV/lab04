package com.example.lab04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab04.ui.theme.Lab04Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab04Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
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
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Nombres",
                            color = MaterialTheme.colorScheme.onPrimary,
                            style = MaterialTheme.typography.titleLarge
                        )
                        Categorias("Agregar")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                modifier = Modifier.fillMaxWidth()
            )
        },

        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* Acción del FAB */ },
                containerColor = MaterialTheme.colorScheme.secondary
            ) {
                Icon(Icons.Default.Add, contentDescription = "Agregar", tint = Color.White)
            }
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp) // Espaciado más uniforme
            ) {
                Text(
                    text = "Categorías",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.padding(bottom = 8.dp),
                    color = MaterialTheme.colorScheme.primary
                )

                // Sección de categorías
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Categorias("Alumnos")
                    Categorias("Egresados")
                    Categorias("Otros")
                }

                // Lista de nombres
                Spacer(modifier = Modifier.height(16.dp)) // Espacio antes de la lista
                ListaNombres(
                    listOf("Juan", "Pedro", "Maria", "Ana", "Luis"),
                    Modifier.fillMaxWidth()
                )
            }
        }
    )
}

@Composable
fun Categorias(cat: String) {
    AssistChip(
        onClick = { /* Acción al hacer clic en el chip */ },
        label = {
            Text(
                cat,
                color = Color.White, 
                style = MaterialTheme.typography.bodyMedium
            )
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = "Editar",
                tint = Color.White
            )
        },
        modifier = Modifier
            .padding(8.dp)
            .shadow(4.dp, shape = MaterialTheme.shapes.medium)
            .background(MaterialTheme.colorScheme.primary)
            .padding(horizontal = 16.dp, vertical = 8.dp),
        colors = AssistChipDefaults.assistChipColors(
            containerColor = MaterialTheme.colorScheme.primary,
            labelColor = Color.White
        )
    )
}


@Composable
fun ListaNombres(nombres: List<String>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .padding(8.dp)
            .background(MaterialTheme.colorScheme.surface) // Añadimos un fondo de color
            .padding(8.dp) // Añadimos más padding
    ) {
        items(nombres) { nombre ->
            ItemNombre(nombre)
            Spacer(modifier = Modifier.height(8.dp)) // Añadimos espacio entre los items
        }
    }
}


@Composable
fun ItemNombre(nombre: String) {
    Text(
        text = nombre,
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth(),
        style = MaterialTheme.typography.bodyLarge,
        color = MaterialTheme.colorScheme.onBackground
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PantallaPrincipalPreview() {
    Lab04Theme {
        PantallaPrincipal()
    }
}

