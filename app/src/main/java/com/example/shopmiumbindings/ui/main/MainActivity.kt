package com.example.shopmiumbindings.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.shopmiumbindings.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewBinding.lifecycleOwner = this // need this one to receive updates from LiveData
        viewBinding.viewmodel = viewModel // inject viewModel

        initImage()
    }

    private fun initImage() {
        viewBinding.showHeaderImage = viewModel.shouldShowImageHeader() // inject data
    }
}
