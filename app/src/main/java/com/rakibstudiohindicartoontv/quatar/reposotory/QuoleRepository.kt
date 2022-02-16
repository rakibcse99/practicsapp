package com.rakibstudiohindicartoontv.quatar.reposotory


import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rakibstudiohindicartoontv.models.QuoteList

import com.rakibstudiohindicartoontv.quatar.api.QuoteService
import com.rakibstudiohindicartoontv.quatar.db.QuoteDatabase
import com.rakibstudiohindicartoontv.quatar.model2.NewsList
import com.rakibstudiohindicartoontv.quatar.utility.NetworkUtils
import com.rakibstudiohindicartoontv.quatar.utility.Resource

class QuoleRepository(private val quoteservice: QuoteService,
                      private val database:QuoteDatabase,
                      private val context: Context) {

     private  val quoteLiveData= MutableLiveData<Resource<QuoteList>>()

    val quotes: LiveData<Resource<QuoteList>>get()=quoteLiveData

     suspend fun getQuote(page: Int){
     if (NetworkUtils.isInternetAvailable(context)) {

        try {
            val result = quoteservice.getQuotes(page)
            if (result?.body() != null) {
                database.quoteDao().addQuotes(result.body()!!.results)
                quoteLiveData.postValue(Resource.Succecss(result.body()))


            }
        }catch (e: Exception){
            quoteLiveData.postValue(Resource.Error(e.message.toString()))
        }

    }
    else{
        val quote=database.quoteDao().getallQuote()
        val quoteList= QuoteList(1,1,1,quote,1,1)

        quoteLiveData.postValue(Resource.Succecss(quoteList))

    }
}
//    suspend fun  getQuatesBacround(){
//         val randomNumber=(Math.random() * 10).toInt()
//
//       val result = quoteservice.getQuotes(randomNumber)
//        if (result?.body() != null) {
////            quoteLiveData.postValue(result.body())
//            database.quoteDao().addQuotes(result.body()!!.results)
//
//        }
//
//    }


    //// news repository

    private  val NewsLiveData= MutableLiveData<Resource<NewsList>>()
    val news: LiveData<Resource<NewsList>>
        get()=NewsLiveData

    suspend fun  getNews(country: String,page: Int){

        try {
            val result = quoteservice.getBreakingNews(country,page)
            if (result?.body() != null) {
//                database.quoteDao().addQuotes(result.body()!!.results)
                NewsLiveData.postValue(Resource.Succecss(result.body()))


            }
        }catch (e: Exception){
            NewsLiveData.postValue(Resource.Error(e.message.toString()))
        }


    }

}