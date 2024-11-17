package com.example.monprofil.ui.theme

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.monprofil.TmdbAPI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainViewModel : ViewModel () {
    val movies = MutableStateFlow<List<Movie>>(listOf())
    val apikey = "474915450c136f48794281389330d269"

    val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    val client = OkHttpClient.Builder()

        .addInterceptor(loggingInterceptor)

        .build()

    val service = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(MoshiConverterFactory.create())
        .client(client)
        .build()
        .create(TmdbAPI::class.java)

//    fun searchMovies(motcle: String){
//        viewModelScope.launch{
//            movies.value = service.getFilmsParMotCle(apikey, motcle).results
//        }
//    }

    init {
        getMovies()
    }

    private fun getMovies(){
        viewModelScope.launch{
            try{
                Log.v("coucou", "coucou")
                movies.value = service.getTrendingMovies(apikey).results
                Log.v("coucou", "coucou2")
            } catch (e:Exception){
                Log.e("MovieViewModel", "Erreur lors de la récupération des films: ${e.message}")
            }

        }
    }


}