package com.example.flowrspot.screens.home

import android.content.Context
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flowrspot.database.AppDatabase
import com.example.flowrspot.models.FlowerProperty
import com.example.flowrspot.network.FlowerAPI
import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val appDatabase: AppDatabase
) : ViewModel() {



    private var _flowers = MutableLiveData<List<FlowerProperty>>(listOf())
    val flowers: LiveData<List<FlowerProperty>>
        get() = _flowers

    private var _paginationLoading = MutableLiveData<Int>()
    val paginationLoading: LiveData<Int>
        get() = _paginationLoading

    private var page: Int = 1

    init {
        viewModelScope.launch(Dispatchers.IO) {
            getAllFlowers()
        }
    }


    private suspend fun getAllFlowers() {
        try {
            _paginationLoading.postValue(View.VISIBLE)
            _flowers.postValue(_flowers.value?.plus(FlowerAPI.flowrsportservice.getFlowers(page).await().flowers))
            _paginationLoading.postValue(View.GONE)
        }
        catch (t: Throwable) {
            t.message?.let { message ->Firebase.crashlytics.log(message)}
        }
    }


     fun searchForFlowers (searchBy:String?) {
         viewModelScope.launch(Dispatchers.IO) {
             page = 1
             try {
                 _flowers.postValue(
                     FlowerAPI.flowrsportservice.searchFlowers(searchBy).await().flowers
                 )
             } catch (t: Throwable) {
                 t.message?.let { message -> Firebase.crashlytics.log(message) }
             }
         }
     }

    fun loadNextpage () {
         page ++
         viewModelScope.launch(Dispatchers.IO) {
             getAllFlowers()
         }
     }

}