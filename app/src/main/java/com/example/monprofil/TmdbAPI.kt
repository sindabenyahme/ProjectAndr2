package com.example.monprofil
import com.example.monprofil.ui.theme.TmbdResult
import retrofit2.http.GET
import retrofit2.http.Query

interface TmdbAPI {
   @GET("search/movie")
    suspend
   fun getFilmsParMotCle(@Query("api_key") apikey:String,@Query("query") motcle :String): TmbdResult

    @GET("trending/movie/week")
    suspend fun getTrendingMovies(@Query("api_key") apikey:String): TmbdResult
}
