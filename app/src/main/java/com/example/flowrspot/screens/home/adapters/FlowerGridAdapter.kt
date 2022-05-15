package com.example.flowrspot.screens.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.flowrspot.databinding.FlowerItemBinding
import com.example.flowrspot.models.FlowerProperty

class FlowerGridAdapter : ListAdapter<FlowerProperty, FlowerPropertyViewHolder>(
    DiffCallback
) {

    companion object DiffCallback : DiffUtil.ItemCallback<FlowerProperty>() {
        override fun areItemsTheSame(oldItem: FlowerProperty, newItem: FlowerProperty): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: FlowerProperty, newItem: FlowerProperty): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FlowerPropertyViewHolder {
        return FlowerPropertyViewHolder(FlowerItemBinding.inflate(LayoutInflater.from(parent.context)))

    }

    override fun onBindViewHolder(
        holder: FlowerPropertyViewHolder,
        position: Int
    ) {
        val flowerProperty = getItem(position)
        holder.bind(flowerProperty)
    }

}
