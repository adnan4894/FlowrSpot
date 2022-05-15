package com.example.flowrspot.network


import com.example.flowrspot.screens.home.models.Flowers
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface FlowrspotApiService {
    @GET("api/v1/flowers")
    fun getFlowers(@Query("page") type: Int?):
            Deferred<Flowers>

    @GET("api/v1/flowers/search")
    fun searchFlowers(@Query("query") type: String?):
            Deferred<Flowers>
}
