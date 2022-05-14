package com.example.flowrspot.screens.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.flowrspot.R
import com.example.flowrspot.database.AppDatabase
import com.example.flowrspot.databinding.FragmentHomeBinding
import com.example.flowrspot.screens.home.adapters.FlowerGridAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {


        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        binding.flowersGrid.adapter = FlowerGridAdapter()


        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.searchForFlowers(newText)
                return true
            }
            override fun onQueryTextSubmit(query: String?): Boolean = false
        })


        binding.flowersGrid.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                    if(!recyclerView.canScrollVertically(1))
                        viewModel.loadNextpage()
            }
        })

        return binding.root
    }
}