package com.example.monprofil

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.material3.Scaffold

import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.monprofil.ui.theme.ActeurScreen

import com.example.monprofil.ui.theme.FilmScreen
import com.example.monprofil.ui.theme.MainViewModel
import com.example.monprofil.ui.theme.MonProfilTheme
import com.example.monprofil.ui.theme.ProfilScreen
import com.example.monprofil.ui.theme.SeriesScreen



class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MonProfilTheme {
                val navController = rememberNavController()

                // Crée une instance du ViewModel dans l'Activity
                val mainViewModel: MainViewModel = viewModel()

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(navController = navController, startDestination = "profil") {
                        composable("profil") { ProfilScreen(navController) }
                        composable("film") { FilmScreen(navController, mainViewModel) }
                        composable("series") { SeriesScreen(navController) }
                        composable("acteur") { ActeurScreen(navController) }
                    }
                }
            }
        }
    }
}









