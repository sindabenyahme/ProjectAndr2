package com.example.monprofil
import com.example.monprofil.ui.theme.TmdbSeries

import retrofit2.http.GET
import retrofit2.http.Query

interface TmdbSeries {
        @GET("discover/tv")
        suspend fun getDiscoverTV(
            @Query("api_key") apiKey: String,
            @Query("language") language: String = "fr-FR",
            @Query("sort_by") sortBy: String = "popularity.desc"
        ): TmdbSeries


        @GET("search/tv")
        suspend fun getSeriesParMotCle(
            @Query("api_key") apiKey: String,
            @Query("query") motCle: String,
            @Query("language") language: String = "fr-FR",
            @Query("sort_by") sortBy: String = "popularity.desc"
        ): TmdbSeries
    }

