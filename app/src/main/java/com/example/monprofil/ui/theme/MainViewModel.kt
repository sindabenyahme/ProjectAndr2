package com.example.monprofil.ui.theme

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.monprofil.TmdbAPI
import com.example.monprofil.TmdbSeries
import com.example.monprofil.TmdbActeur

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainViewModel : ViewModel() {
    val movies = MutableStateFlow<List<Movie>>(listOf())
    val series = MutableStateFlow<List<Series>>(listOf())
    val acteurs = MutableStateFlow<List<Acteurs>>(listOf())
    val apikey = "474915450c136f48794281389330d269"

    // Intercepteur de logs
    val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    // Client OkHttp
    val client = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    // Service Retrofit pour les films
    val movieService = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(MoshiConverterFactory.create())
        .client(client)
        .build()
        .create(TmdbAPI::class.java)

    // Service Retrofit pour les séries
    val seriesService = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(MoshiConverterFactory.create())
        .client(client)
        .build()
        .create(TmdbSeries::class.java)


    val acteursService = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(MoshiConverterFactory.create())
        .client(client)
        .build()
        .create(TmdbActeur::class.java)

    // Initialisation des appels
    init {
        getMovies()
        getTrendingSeries()
        getActeurs()

    }

    // Récupérer les films tendances
    private fun getMovies() {
        viewModelScope.launch {
            try {
                Log.v("MainViewModel", "Récupération des films tendances")
                val trendingMovies = movieService.getTrendingMovies(apikey)
                movies.value = trendingMovies.results
            } catch (e: Exception) {
                Log.e("MainViewModel", "Erreur lors de la récupération des films: ${e.message}")
            }
        }
    }

    // Recherche de films par mot-clé
    fun searchMovies(motcle: String) {
        viewModelScope.launch {
            try {
                val searchResult = movieService.getFilmsParMotCle(apikey, motcle)
                movies.value = searchResult.results
            } catch (e: Exception) {
                Log.e("MainViewModel", "Erreur lors de la recherche de films: ${e.message}")
            }
        }
    }

    // Récupérer les séries tendances
    private fun getTrendingSeries() {
        viewModelScope.launch {
            try {
                Log.v("MainViewModel", "Récupération des séries tendances")
                val trendingSeries = seriesService.getDiscoverTV(apikey)
                series.value = trendingSeries.results
            } catch (e: Exception) {
                Log.e("MainViewModel", "Erreur lors de la récupération des séries: ${e.message}")
            }
        }
    }

    // Recherche de séries par mot-clé
    fun searchSeries(motcle: String) {
        viewModelScope.launch {
            try {
                val searchResult = seriesService.getSeriesParMotCle(apikey, motcle)
                series.value = searchResult.results
            } catch (e: Exception) {
                Log.e("MainViewModel", "Erreur lors de la recherche de séries: ${e.message}")
            }
        }
    }




    // Récupérer les acteurs tendances
    private fun getActeurs() {
        viewModelScope.launch {
            try {
                Log.v("MainViewModel", "Récupération des acteurs tendances")
                val trendingActeurs = acteursService.getActeur(apikey)
                acteurs.value = trendingActeurs.results
            } catch (e: Exception) {
                Log.e("MainViewModel", "Erreur lors de la récupération des acteurs: ${e.message}")
            }
        }
    }


    fun searchActeurs(motcle: String) {
        viewModelScope.launch {
            try {
                val searchResult = acteursService.getActeurParMotCle(apikey, motcle)
                acteurs.value = searchResult.results
            } catch (e: Exception) {
                Log.e("MainViewModel", "Erreur lors de la recherche d'acteurs: ${e.message}")
            }
        }
    }


}




