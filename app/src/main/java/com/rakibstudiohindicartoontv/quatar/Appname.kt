package com.rakibstudiohindicartoontv.quatar

import android.app.Application
import android.provider.SyncStateContract
import androidx.constraintlayout.widget.ConstraintSet
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.rakibstudiohindicartoontv.quatar.api.QuoteService
import com.rakibstudiohindicartoontv.quatar.api.RetrofiteHelper
import com.rakibstudiohindicartoontv.quatar.api2.NewsService
import com.rakibstudiohindicartoontv.quatar.db.QuoteDatabase
import com.rakibstudiohindicartoontv.quatar.repository2.NewsReposotory
import com.rakibstudiohindicartoontv.quatar.reposotory.QuoleRepository
import com.rakibstudiohindicartoontv.quatar.workar.QuateWorker
import java.util.concurrent.TimeUnit

class Appname: Application() {
    lateinit var quoteRepository: QuoleRepository
//    lateinit var  newsReposotory: NewsReposotory

    lateinit var  newsReposotory:QuoleRepository
    override fun onCreate() {
        super.onCreate()
        insialize()
//        setWorker()

//        newsIsialize()
    }

//    private fun newsIsialize() {
//        val newsservice=RetrofiteHelper.getInstancNews().create(NewsService::class.java)
//        newsReposotory=QuoleRepository(newsservice,applicationContext)
//    }

//    private fun setWorker() {
//      val constane= Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()
//
//        val workRequest= PeriodicWorkRequest.Builder(QuateWorker::class.java,2,TimeUnit.MINUTES)
//            .setConstraints(constane).build()
//        WorkManager.getInstance(this).enqueue(workRequest)
//    }

    private fun insialize() {
        val newsservice=RetrofiteHelper.getInstancNews().create(QuoteService::class.java)
        val quotesevice=RetrofiteHelper.getInstance().create(QuoteService::class.java)
        val datbase= QuoteDatabase.getDatabase(applicationContext)
        quoteRepository= QuoleRepository(quotesevice,datbase,applicationContext)
        newsReposotory= QuoleRepository(newsservice,datbase,applicationContext)

    }

}