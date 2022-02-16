package com.rakibstudiohindicartoontv.quatar.viewmodel2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rakibstudiohindicartoontv.quatar.repository2.NewsReposotory
import com.rakibstudiohindicartoontv.quatar.reposotory.QuoleRepository
import com.rakibstudiohindicartoontv.quatar.viewmodel.MainViewModel

class NewsViewModelFactory(val newsReposotory: NewsReposotory): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        return  NewsViewModel (newsReposotory) as T
    }
}