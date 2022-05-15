package com.example.flowrspot.screens.home

import android.view.View
import com.example.flowrspot.base.BaseFullScreenState
import com.example.flowrspot.models.FlowerProperty

data class HomeFullScreenState(
    val flowers: List<FlowerProperty> = listOf(),
    val paginationLoading: Int = View.VISIBLE,
    val page: Int = 0
) : BaseFullScreenState
