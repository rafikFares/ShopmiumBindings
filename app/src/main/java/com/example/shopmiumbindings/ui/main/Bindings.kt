package com.example.shopmiumbindings.ui.main // ktlint-disable filename

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("bind:adapter")
fun RecyclerView.initialize(mainAdapter: MainAdapter) {
    setHasFixedSize(true)
    adapter = mainAdapter
}
