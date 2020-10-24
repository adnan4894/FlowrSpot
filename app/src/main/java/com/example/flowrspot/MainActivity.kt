package com.example.flowrspot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import android.util.Log
//import android.widget.TextView
//import com.example.flowrspot.network.FlowerProperty
//import com.example.flowrspot.network.Flowers
//import com.example.flowrspot.network.FlowrspotApi
//import retrofit2.Call
//import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        FlowrspotApi.flowrsportservice.getFlowers().enqueue(object :
//            retrofit2.Callback<Flowers> {
//
//            override fun onFailure(call: Call<Flowers>, t: Throwable) {
//                Log.i("res",t.message)
//            }
//
//            override fun onResponse(
//                call: Call<Flowers>,
//                response: Response<Flowers>
//            ) {
//                Log.i("res", response.body()?.flowers.toString())
//            }
//
//        })
    }
}


