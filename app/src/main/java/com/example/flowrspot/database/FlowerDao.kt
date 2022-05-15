package com.example.flowrspot.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.flowrspot.screens.home.models.FlowerProperty

@Dao
interface FlowerDao {
    @Query("SELECT * FROM FlowerProperty")
    fun getAllFlowers() : List<FlowerProperty>

    @Insert
    fun insertAll(listOfFlowers : List<FlowerProperty>)
}