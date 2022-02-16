package com.rakibstudiohindicartoontv.quatar.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.rakibstudiohindicartoontv.models.Result
import com.rakibstudiohindicartoontv.quatar.api2.Utilclass
import com.rakibstudiohindicartoontv.quatar.model2.NewsList
import retrofit2.Response
import retrofit2.http.GET


@Dao
interface Quotedao {

    @Insert
    suspend fun addQuotes( quote: List<Result>)

    @Query("SELECT * FROM quote")
    suspend fun getallQuote(): List<Result>





}