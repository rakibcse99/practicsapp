package com.rakibstudiohindicartoontv.quatar.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rakibstudiohindicartoontv.quatar.repository2.NewsReposotory
import com.rakibstudiohindicartoontv.quatar.reposotory.QuoleRepository

class ViewModelFactrory(val quoleRepository: QuoleRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

   return  MainViewModel(quoleRepository) as T
    }
}