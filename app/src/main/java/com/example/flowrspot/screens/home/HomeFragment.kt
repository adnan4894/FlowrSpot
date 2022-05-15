package com.example.flowrspot.screens.home

import android.widget.SearchView
import androidx.recyclerview.widget.RecyclerView
import com.example.flowrspot.R
import com.example.flowrspot.base.BaseFragment
import com.example.flowrspot.databinding.FragmentHomeBinding
import com.example.flowrspot.screens.home.adapters.FlowerGridAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment :
    BaseFragment<FragmentHomeBinding, HomeViewModel, HomeEvents, HomeFullScreenState>(R.layout.fragment_home, HomeViewModel::class.java) {

    override fun initUI() {
        binding.apply {
            flowersGrid.adapter = FlowerGridAdapter()

            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextChange(newText: String?): Boolean {
                    viewModel?.setNewState(SearchHomeEvent(newText ?: ""))
                    return true
                }

                override fun onQueryTextSubmit(query: String?): Boolean = false
            })


            flowersGrid.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    if (!recyclerView.canScrollVertically(1))
                        viewModel?.setNewState(ScrolledToBottomHomeEvent)
                }
            })
        }
    }

    override fun onLoad() {
        viewModel.setNewState(LoadHomeEvent)
    }
}