package com.example.flowrspot.screens.home

import kotlinx.coroutines.flow.Flow


interface HomeEvents {
    fun searchEvent() : Flow<String>
    fun scrolledToBottomEvent() : Flow<Boolean>
}

