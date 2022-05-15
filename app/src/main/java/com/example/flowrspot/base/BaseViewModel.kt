package com.example.flowrspot.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

abstract class BaseViewModel<Event, State : BaseFullScreenState>(initialStateValue: State) : ViewModel() {

    private val screenStateMutableLiveData: MutableLiveData<State> = MutableLiveData(initialStateValue)
    val screenState: LiveData<State> get() = screenStateMutableLiveData

    fun setNewState(event: Event) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val dataResult = handleEvent(event)
                withContext(Dispatchers.Main) {
                    screenStateMutableLiveData.value = dataResult
                }
            }
        }.start()
    }

    protected abstract suspend fun handleEvent(event: Event): State
    //Arhitecture in progress
}