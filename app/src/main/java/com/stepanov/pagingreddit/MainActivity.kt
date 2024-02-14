package com.stepanov.pagingreddit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.stepanov.pagingreddit.adapter.HotPostsPagerAdapter
import com.stepanov.pagingreddit.databinding.ActivityMainBinding
import com.stepanov.pagingreddit.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity() : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: HotPostsPagerAdapter

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setupRv()
        loadingData()

    }

    private fun loadingData() {
        lifecycleScope.launch {
            viewModel.listData.collect { pagingData ->
                adapter.submitData(pagingData)

            }
        }
    }

    private fun setupRv() {
        adapter = HotPostsPagerAdapter()
        binding.recyclerView.apply {
            layoutManager = StaggeredGridLayoutManager(
                2, StaggeredGridLayoutManager.VERTICAL
            )
            adapter = this@MainActivity.adapter
            setHasFixedSize(true)
        }
    }


}
}


