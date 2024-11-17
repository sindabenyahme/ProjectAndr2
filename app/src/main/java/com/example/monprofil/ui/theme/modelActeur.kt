package com.example.monprofil.ui.theme

data class TmdbActeur(

    val results: List<Acteurs>,

)

data class Acteurs(
    val adult: Boolean,
    val gender: Int,
    val id: Int,

    val known_for_department: String,
    val name: String,
    val original_name: String,
    val popularity: Double,
    val profile_path: String
)

