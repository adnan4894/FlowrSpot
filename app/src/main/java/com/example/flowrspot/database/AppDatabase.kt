package com.example.flowrspot.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.flowrspot.screens.home.models.FlowerProperty

@Database(entities = [FlowerProperty::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun flowerDao(): FlowerDao
}