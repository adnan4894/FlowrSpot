package com.example.flowrspot.screens.home

import com.example.flowrspot.base.BaseEvent

sealed class HomeEvents : BaseEvent

object LoadHomeEvent : HomeEvents()
object ScrolledToBottomHomeEvent : HomeEvents()
class SearchHomeEvent(val searchBy: String) : HomeEvents()