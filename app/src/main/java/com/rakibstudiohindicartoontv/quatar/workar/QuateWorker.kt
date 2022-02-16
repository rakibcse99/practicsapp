package com.rakibstudiohindicartoontv.quatar.workar

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.rakibstudiohindicartoontv.quatar.Appname
import com.rakibstudiohindicartoontv.quatar.reposotory.QuoleRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

class QuateWorker(private  val context: Context, params: WorkerParameters): Worker(context,params){
    override fun doWork(): Result {
        val repository=(context as Appname).quoteRepository
CoroutineScope(Dispatchers.IO).launch {
 //   repository.getQuatesBacround()
}
        return Result.success()
    }


}