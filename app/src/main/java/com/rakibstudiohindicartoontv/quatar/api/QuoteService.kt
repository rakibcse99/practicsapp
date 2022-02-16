package com.rakibstudiohindicartoontv.quatar.api


import com.rakibstudiohindicartoontv.models.QuoteList
import com.rakibstudiohindicartoontv.quatar.api2.Utilclass
import com.rakibstudiohindicartoontv.quatar.model2.NewsList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteService {


    @GET("/quotes")
    suspend fun getQuotes(
        @Query("page")page: Int) : Response<QuoteList>

    @GET("v2/top-headlines")
    suspend fun getBreakingNews(
        @retrofit2.http.Query("country")
        countryCode: String = "us",
        @retrofit2.http.Query("page")
        pageNumber: Int = 1,
        @retrofit2.http.Query("apiKey")
        apiKey: String = Utilclass.API_KEY
    ): Response<NewsList>


}