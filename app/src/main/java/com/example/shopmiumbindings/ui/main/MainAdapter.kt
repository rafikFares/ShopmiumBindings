package com.example.shopmiumbindings.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.shopmiumbindings.R

class MainAdapter : ListAdapter<ItemData, MainAdapter.ItemViewHolder>(ITEM_DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(view)
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
        private val view: View
    ) : RecyclerView.ViewHolder(view) {
        fun bind(itemData: ItemData) {
            view.findViewById<TextView>(R.id.itemTextView).apply {
                text = itemData.data
            }
        }
    }
}
