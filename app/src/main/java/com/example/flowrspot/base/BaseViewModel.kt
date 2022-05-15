package com.example.flowrspot.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class BaseViewModel {

    private val dataStateMutableLiveData: MutableLiveData<BaseState> = MutableLiveData()
    val dataState: LiveData<BaseState> get() = dataStateMutableLiveData

    fun triggerEvent(event : BaseEvent) {
        viewModelScope.launch(Dispatchers.IO) {
            val doActionForEvent(event)
        }
    }

    protected abstract suspend fun doActionForEvent(event: BaseEvent): BaseState

}