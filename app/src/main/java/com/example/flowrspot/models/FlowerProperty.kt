package com.example.flowrspot.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FlowerProperty(
    @PrimaryKey val id: Int,
    val name: String,
    val latin_name: String,
    val sightings: Int,
    val profile_picture: String,
    val favorite: Boolean
)