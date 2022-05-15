package com.example.flowrspot.screens.home

import android.view.View

import com.example.flowrspot.base.BaseViewModel
import com.example.flowrspot.database.AppDatabase
import com.example.flowrspot.network.FlowerAPI
import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val appDatabase: AppDatabase
) : BaseViewModel<HomeEvents, HomeFullScreenState>(HomeFullScreenState()) {

    override suspend fun handleEvent(event: HomeEvents): HomeFullScreenState {
        return when (event) {
            is LoadHomeEvent -> {
                getAllFlowers()
            }
            is SearchHomeEvent -> {
                searchForFlowers(event.searchBy)
            }
            is ScrolledToBottomHomeEvent -> {
                getAllFlowers()
            }
        }
    }

    private suspend fun getAllFlowers(): HomeFullScreenState {
        screenState.value?.let {
            try {
                val getFlowers = FlowerAPI.flowrsportservice.getFlowers(it.page).await().flowers
                return it.copy(flowers = it.flowers.plus(getFlowers), paginationLoading = View.GONE, page = it.page + 1)
            } catch (t: Throwable) {
                t.message?.let { message -> Firebase.crashlytics.log(message) }
            }
        }
        return HomeFullScreenState()
    }


    private suspend fun searchForFlowers(searchBy: String?): HomeFullScreenState {
        screenState.value?.let {
            try {
                val flowers = FlowerAPI.flowrsportservice.searchFlowers(searchBy).await().flowers
                return it.copy(flowers = flowers, paginationLoading = View.GONE, page = 0)
            } catch (t: Throwable) {
                t.message?.let { message -> Firebase.crashlytics.log(message) }
            }
        }
        return HomeFullScreenState()
    }
}



