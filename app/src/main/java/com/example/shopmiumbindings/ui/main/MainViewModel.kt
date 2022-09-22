package com.example.shopmiumbindings.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _buttonText: MutableLiveData<String> = MutableLiveData<String>().apply {
        value = "Click Me ?"
    }
    val buttonText: LiveData<String> = _buttonText

    val mainAdapter: MainAdapter = MainAdapter()

    fun shouldShowImageHeader() = true

    private fun createFakeData(): List<ItemData> =
        (0..50).map { ItemData("$it") }

    fun onButtonClick() {
        _buttonText.value = "Clicked!!"
        val items = createFakeData()
        mainAdapter.submitList(items)
    }
}
