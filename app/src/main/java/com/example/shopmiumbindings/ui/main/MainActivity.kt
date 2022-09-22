package com.example.shopmiumbindings.ui.main

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.shopmiumbindings.R
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var headerImageView: ImageView
    private lateinit var listView: RecyclerView
    private lateinit var buttonView: MaterialButton
    private lateinit var mainAdapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        mainAdapter = MainAdapter()
        headerImageView = findViewById<ImageView>(R.id.headerImageView)
        listView = findViewById<RecyclerView>(R.id.listView)
        buttonView = findViewById<MaterialButton>(R.id.buttonView)

        initList()
        initButton()
    }

    private fun initList() {
        listView.setHasFixedSize(true)
        listView.adapter = mainAdapter
    }

    private fun initButton() {
        buttonView.setOnClickListener {
            val items = viewModel.createFakeData()
            (listView.adapter as MainAdapter).submitList(items)
        }
    }
}
