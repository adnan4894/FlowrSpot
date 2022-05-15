package com.example.flowrspot.network


import com.example.flowrspot.models.Flowers
import kotlinx.coroutines.Deferred
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
