package com.example.flowrspot.screens.home.adapters

import androidx.recyclerview.widget.RecyclerView
import com.example.flowrspot.databinding.FlowerItemBinding
import com.example.flowrspot.models.FlowerProperty

class FlowerPropertyViewHolder(private var binding: FlowerItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(flowerProperty: FlowerProperty) {
        binding.flower = flowerProperty
        binding.executePendingBindings()
    }
}