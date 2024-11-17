package com.example.monprofil.ui.theme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.Tv
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Person

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun SeriesScreen(navController: NavController) {
    Scaffold(
        bottomBar = {
            NavigationBar (containerColor = Color(0xFFADD8E6))
            {
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
        Box(
            modifier = Modifier.padding(innerPadding).fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Séries", fontSize = 32.sp)
        }
    }
}