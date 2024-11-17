package com.example.monprofil.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Tv
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilmScreen(navController: NavController, viewModel: MainViewModel) {
    // Observer les films dans le ViewModel
    val movies by viewModel.movies.collectAsState()

    Scaffold(
        bottomBar = {
            NavigationBar(containerColor = Color(0xFFADD8E6)) {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Movie, contentDescription = "Film") },
                    label = { Text("Film") },
                    selected = false,
                    onClick = { navController.navigate("film") }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Tv, contentDescription = "Series") },
                    label = { Text("Series") },
                    selected = false,
                    onClick = { navController.navigate("series") }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Star, contentDescription = "Acteur") },
                    label = { Text("Acteur") },
                    selected = false,
                    onClick = { navController.navigate("acteur") }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = "Profil") },
                    label = { Text("Profil") },
                    selected = false,
                    onClick = { navController.navigate("profil") }
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top
        ) {
            // Ligne avec texte à gauche et barre de recherche à droite
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically, // Aligner verticalement au centre
                horizontalArrangement = Arrangement.SpaceBetween // Espacer les éléments
            ) {
                // Texte à gauche
                Text(
                    text = "FavAPP",
                    fontSize = 24.sp, // Taille du texte
                    fontWeight = FontWeight.Bold, // Texte en gras
                    color = Color.Black, // Couleur du texte
                    modifier = Modifier.weight(1f) // Prendre de l'espace à gauche
                )

                var searchText by remember { mutableStateOf(TextFieldValue("")) }
                TextField(
                    value = searchText,
                    onValueChange = { searchText = it },
                    placeholder = { Text("Rechercher film ...") },
                    modifier = Modifier
                    )
            }
                Spacer(modifier = Modifier.height(16.dp))

            // Grille des films (responsive)
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 150.dp), // Responsive grid
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {
                items(movies) { movie ->
                    FilmCard(movie = movie)
                }
            }
        }
    }
}

