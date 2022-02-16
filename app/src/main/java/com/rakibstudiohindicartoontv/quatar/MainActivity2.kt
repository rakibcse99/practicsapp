package com.rakibstudiohindicartoontv.quatar

import android.app.Activity
import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.rakibstudiohindicartoontv.quatar.adapter.NewsAdapter
import com.rakibstudiohindicartoontv.quatar.adapter.QuateAdapter
import com.rakibstudiohindicartoontv.quatar.databinding.ActivityMain2Binding
import com.rakibstudiohindicartoontv.quatar.repository2.NewsReposotory
import com.rakibstudiohindicartoontv.quatar.utility.Resource
import com.rakibstudiohindicartoontv.quatar.viewmodel.MainViewModel
import com.rakibstudiohindicartoontv.quatar.viewmodel.ViewModelFactrory
import com.rakibstudiohindicartoontv.quatar.viewmodel2.NewsViewModel
import com.rakibstudiohindicartoontv.quatar.viewmodel2.NewsViewModelFactory

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding

    lateinit var  adapterr: NewsAdapter
    lateinit var mainViewModel: MainViewModel
    lateinit var newssReposotory: NewsReposotory
    lateinit var  newsViewModelFactory: NewsViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)



        val repository=(application as Appname).newsReposotory

        mainViewModel = ViewModelProvider(this, ViewModelFactrory(repository))
            .get(MainViewModel::class.java)


        mainViewModel.news.observe(this, Observer {
            when (it) {
                is Resource.Loading -> {

                }
                is Resource.Succecss -> {
                    it.data?.let { newsrepose ->

                        adapterr.differ.submitList(newsrepose.articles.toList())

                    }

                }
                is Resource.Error -> {
                    it.massage?.let { massage ->

                        Log.e(ContentValues.TAG, "An error occured: $massage")
                    }

                }
            }


//            Log.d("rakib",it.results.toString())
        })

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.rvBreakingNews.apply {
            adapterr = NewsAdapter()
            layoutManager = LinearLayoutManager(application)
           adapter = adapterr
        }

    }


}