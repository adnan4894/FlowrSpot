package com.example.flowrspot.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://flowrspot-api.herokuapp.com/"

private  val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface FlowrspotApiService {
    @GET("api/v1/flowers")
    fun getFlowers():
            Call<Flowers>
}

object FlowrspotApi {
    val flowrsportservice : FlowrspotApiService by lazy {
        retrofit.create(FlowrspotApiService::class.java)
    }
}