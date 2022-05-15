package com.example.flowrspot.screens.home

import com.example.flowrspot.screens.home.models.FlowerProperty
import com.example.flowrspot.network.FlowerAPI
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class HomeViewModelTest {

    @Test
    fun checkTypeOfApiResponseAfterConversion () = runBlocking{
        val flower = FlowerProperty(1,"test","test",1,"test",false)
        val result = FlowerAPI.flowrsportservice.getFlowers(1).await().flowers[0]
        Assert.assertEquals(flower.javaClass.name, result.javaClass.name)
    }

    @Test
    fun searchByName () = runBlocking {
        val flower = FlowerProperty(7,"Alpski","Volcin",1,"test",false)
        val searchBy = "Alpski"
        val result = FlowerAPI.flowrsportservice.searchFlowers(searchBy).await().flowers[0]
        Assert.assertEquals(flower.id,result.id)
    }

    @Test
    fun searchByLatinName () = runBlocking {
        val flower = FlowerProperty(14,"Bee orchi","Ophrys apifera",1,"test",false)
        val searchBy = "Ophrys apifera"
        val result = FlowerAPI.flowrsportservice.searchFlowers(searchBy).await().flowers[0]
        Assert.assertEquals(flower.id,result.id)
    }
}