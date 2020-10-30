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
import kotlin.math.log


class HomeViewModel : ViewModel() {

    private var _flowers = MutableLiveData<List<FlowerProperty>>()
    val flowers: LiveData<List<FlowerProperty>>
        get() = _flowers

    private var _flower = MutableLiveData<FlowerProperty>()
    val flower: LiveData<FlowerProperty>
        get() = _flower

    private var _paginationLoading = MutableLiveData<Int>()
    val paginationLoading: LiveData<Int>
        get() = _paginationLoading

    private var page: Int = 1



    init {
        CoroutineScope(Dispatchers.Main).launch {
            getAllFlowers()
        }
    }


    private suspend  fun getAllFlowers() {
        try {
            _paginationLoading.value = 0

            if(_flowers.value.isNullOrEmpty())
                _flowers.value = FlowrspotApi.flowrsportservice.getFlowers(page).await().flowers

            else _flowers.value = _flowers.value!! + FlowrspotApi.flowrsportservice.getFlowers(page).await().flowers

            _paginationLoading.value = 8

        }
        catch (t: Throwable) { Log.i("error",t.message!!) }
    }


    suspend fun  searchForFlowers (searchBy:String?) {
         page = 1
         try { _flowers.value = FlowrspotApi.flowrsportservice.searchFlowers(searchBy).await().flowers }
         catch (t: Throwable) { Log.i("error",t.message!!) }
     }


    fun  loadNextpage () {
         page ++
         CoroutineScope(Dispatchers.Main).launch {
             getAllFlowers()
         }
     }

}