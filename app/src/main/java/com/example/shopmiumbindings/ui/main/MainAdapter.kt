package com.example.shopmiumbindings.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.shopmiumbindings.databinding.ListItemBinding

class MainAdapter : ListAdapter<ItemData, MainAdapter.ItemViewHolder>(ITEM_DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val itemData = currentList[position]
        holder.bind(itemData)
    }

    companion object {
        private val ITEM_DIFF_CALLBACK = object : DiffUtil.ItemCallback<ItemData>() {
            override fun areItemsTheSame(oldItem: ItemData, newItem: ItemData): Boolean =
                oldItem.data == newItem.data

            override fun areContentsTheSame(oldItem: ItemData, newItem: ItemData): Boolean =
                oldItem == newItem
        }
    }

    inner class ItemViewHolder(
        private val binding: ListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(itemData: ItemData) {
            // binding.itemTextView.text = itemData.data // can be used too
            binding.itemData = itemData
        }
    }
}
