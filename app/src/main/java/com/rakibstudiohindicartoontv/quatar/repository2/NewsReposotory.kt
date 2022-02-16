package com.rakibstudiohindicartoontv.quatar.repository2

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rakibstudiohindicartoontv.models.QuoteList
import com.rakibstudiohindicartoontv.quatar.api2.NewsService
import com.rakibstudiohindicartoontv.quatar.model2.NewsList
import com.rakibstudiohindicartoontv.quatar.utility.Resource

class NewsReposotory(private  val newsService: NewsService,private  val  context: Context) {

    private  val NewsLiveData= MutableLiveData<Resource<NewsList>>()
    val news: LiveData<Resource<NewsList>>
        get()=NewsLiveData

    suspend fun  getNews(country: String,page: Int){

        try {
            val result = newsService.getBreakingNews(country,page)
            if (result?.body() != null) {
//                database.quoteDao().addQuotes(result.body()!!.results)
                NewsLiveData.postValue(Resource.Succecss(result.body()))


            }
        }catch (e: Exception){
            NewsLiveData.postValue(Resource.Error(e.message.toString()))
        }


    }





}