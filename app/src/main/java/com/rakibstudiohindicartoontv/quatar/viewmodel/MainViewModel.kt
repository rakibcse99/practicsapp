package com.rakibstudiohindicartoontv.quatar.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rakibstudiohindicartoontv.models.QuoteList
import com.rakibstudiohindicartoontv.quatar.model2.NewsList
import com.rakibstudiohindicartoontv.quatar.reposotory.QuoleRepository
import com.rakibstudiohindicartoontv.quatar.utility.Resource
import kotlinx.coroutines.Dispatchers


import kotlinx.coroutines.launch

class MainViewModel(val quoterepository:QuoleRepository): ViewModel() {



    init {
        viewModelScope.launch(Dispatchers.IO){
            quoterepository.getQuote(1)
        }


    }
    val quotes : LiveData<Resource<QuoteList>>
        get() = quoterepository.quotes






    init {
        viewModelScope.launch(Dispatchers.IO){
            quoterepository.getNews("us",1)
        }




    }

    val news : LiveData<Resource<NewsList>>
        get() = quoterepository.news
}