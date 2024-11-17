package com.example.monprofil

import retrofit2.http.GET
import retrofit2.http.Query
import com.example.monprofil.ui.theme.TmdbActeur
interface TmdbActeur {


    @GET("person/popular")
        suspend fun getActeur(
            @Query("api_key") apiKey: String,
            @Query("language") language: String = "fr-FR",
            @Query("sort_by") sortBy: String = "popularity.desc"
        ): TmdbActeur


    @GET("search/person")
        suspend fun getActeurParMotCle(
            @Query("api_key") apiKey: String,
            @Query("query") motCle: String,
            @Query("language") language: String = "fr-FR",
            @Query("sort_by") sortBy: String = "popularity.desc"
        ): TmdbActeur
}



