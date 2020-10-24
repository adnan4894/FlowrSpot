package com.example.flowrspot.network

data class FlowerProperty(
    val id: Int,
    val name: String,
    val latin_name: String,
    val sightings: Int,
    val favorite: Boolean
)