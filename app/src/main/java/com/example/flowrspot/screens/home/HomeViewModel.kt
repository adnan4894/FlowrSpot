package com.example.flowrspot.screens.home


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.flowrspot.network.FlowerProperty
import com.example.flowrspot.network.Flowers
import com.example.flowrspot.network.FlowrspotApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class HomeViewModel : ViewModel() {

    private var _flowers = MutableLiveData<Flowers>()
    val flowers: LiveData<Flowers>
        get() = _flowers

    private var _flower = MutableLiveData<FlowerProperty>()
    val flower: LiveData<FlowerProperty>
        get() = _flower


    init {
        CoroutineScope(Dispatchers.Main).launch {
            getAllFlowers()
        }
    }

    private suspend  fun getAllFlowers() {
        try { _flowers.value = FlowrspotApi.flowrsportservice.getFlowers().await() }
        catch (t: Throwable) { Log.i("error",t.message!!) }
    }

     suspend fun  searchForFlowers (searchBy:String?) {
         try { _flowers.value = FlowrspotApi.flowrsportservice.searchFlowers(searchBy).await()}
         catch (t: Throwable) { Log.i("error",t.message!!) }
     }

}