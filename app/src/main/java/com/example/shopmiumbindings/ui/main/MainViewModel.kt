package com.example.shopmiumbindings.ui.main

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    fun createFakeData(): List<ItemData> =
        (0..50).map { ItemData("$it") }
}
