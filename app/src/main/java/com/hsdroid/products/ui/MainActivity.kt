package com.hsdroid.products.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.hsdroid.products.viewmodel.ProductViewModel
import com.hsdroid.products.databinding.ActivityMainBinding
import com.hsdroid.products.ui.adapter.RecyclerAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val recyclerAdapter: RecyclerAdapter = RecyclerAdapter()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewModel()
        initRecyclerView()
    }

    private fun initViewModel() {
        val viewModel: ProductViewModel =
            ViewModelProvider(this)[ProductViewModel::class.java]
        viewModel.callData().observe(this, Observer {
            if (it != null) {
                binding.progressCircular.visibility = View.GONE
                recyclerAdapter.setList(it)
            }
        })

        viewModel.getData()
    }

    private fun initRecyclerView() {
        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 2, GridLayoutManager.VERTICAL, false)
            adapter = recyclerAdapter
        }
    }
}