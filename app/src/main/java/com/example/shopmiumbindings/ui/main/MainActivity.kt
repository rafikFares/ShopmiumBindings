package com.example.shopmiumbindings.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.example.shopmiumbindings.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var viewBinding: ActivityMainBinding
    private lateinit var mainAdapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        mainAdapter = MainAdapter()

        initImage()
        initList()
        initButton()
    }

    private fun initImage() {
        viewBinding.headerImageView.isVisible = viewModel.shouldShowImageHeader()
    }

    private fun initList() {
        viewBinding.listView.setHasFixedSize(true)
        viewBinding.listView.adapter = mainAdapter
    }

    private fun initButton() {
        viewBinding.buttonView.setOnClickListener {
            viewBinding.buttonView.text = "Clicked!!"
            val items = viewModel.createFakeData()
            (viewBinding.listView.adapter as MainAdapter).submitList(items)
        }
    }
}
