package com.example.flowrspot.network

data class FlowerProperty(
    val id: Int,
    val name: String,
    val latin_name: String,
    val sightings: Int,
    val profile_picture: String,
    val favorite: Boolean
)