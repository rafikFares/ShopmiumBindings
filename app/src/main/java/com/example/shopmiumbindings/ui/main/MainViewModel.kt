package com.example.shopmiumbindings.ui.main

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _itemDataList = mutableStateListOf<ItemData>()

    val itemDataList: List<ItemData>
        get() = _itemDataList

    fun createFakeData(): List<ItemData> =
        (0..50).map { ItemData("$it") }

    fun onButtonClick() {
        _itemDataList.addAll(createFakeData())
    }
}
