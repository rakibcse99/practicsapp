package com.rakibstudiohindicartoontv.quatar.viewmodel2

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.rakibstudiohindicartoontv.models.QuoteList
import com.rakibstudiohindicartoontv.quatar.model2.NewsList
import com.rakibstudiohindicartoontv.quatar.repository2.NewsReposotory
import com.rakibstudiohindicartoontv.quatar.utility.Resource
import androidx.lifecycle.viewModelScope

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsViewModel(val newsReposotory: NewsReposotory): ViewModel()  {


    init {
        viewModelScope.launch(Dispatchers.IO){
           newsReposotory.getNews("us",1)
        }




    }

    val news : LiveData<Resource<NewsList>>
        get() = newsReposotory.news
}