package com.example.flowrspot.screens.home

import com.example.extension.scrollListener
import com.example.extension.searchListener
import com.example.flowrspot.R
import com.example.flowrspot.base.BaseFragment
import com.example.flowrspot.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter


@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home), HomeEvents {
    override fun searchEvent(): Flow<String> = binding.searchView.searchListener()
    override fun scrolledToBottomEvent(): Flow<Boolean> = binding.flowersGrid.scrollListener().filter { it }
    override fun initUI() {}
}
