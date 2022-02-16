package com.rakibstudiohindicartoontv.quatar

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rakibstudiohindicartoontv.quatar.adapter.QuateAdapter
import com.rakibstudiohindicartoontv.quatar.databinding.ActivityMainBinding
import com.rakibstudiohindicartoontv.quatar.utility.Resource
import com.rakibstudiohindicartoontv.quatar.viewmodel.MainViewModel
import com.rakibstudiohindicartoontv.quatar.viewmodel.ViewModelFactrory

class MainActivity : AppCompatActivity() {

    private lateinit var rvPlaces: RecyclerView
    lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel
    lateinit var quateAdapter: QuateAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val repository = (application as Appname).quoteRepository

        mainViewModel = ViewModelProvider(this, ViewModelFactrory(repository))
            .get(MainViewModel::class.java)
        mainViewModel.quotes.observe(this, Observer {
            when (it) {
                is Resource.Loading -> {

                }
                is Resource.Succecss -> {
                    it.data?.let { quateRespose ->

                        quateAdapter.differ.submitList(quateRespose.results.toList())

                    }

                }
                is Resource.Error -> {
                    it.massage?.let { massage ->

                        Log.e(TAG, "An error occured: $massage")
                    }

                }
            }


//            Log.d("rakib",it.results.toString())
        })

        setupRecyclerView()
    }

    private fun setupRecyclerView() {

        rvPlaces = findViewById(R.id.recyle)
        quateAdapter = QuateAdapter()
        rvPlaces.layoutManager = LinearLayoutManager(this)
        rvPlaces.adapter = quateAdapter


    }

}