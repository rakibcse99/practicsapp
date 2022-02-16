package com.rakibstudiohindicartoontv.quatar.api2

import com.rakibstudiohindicartoontv.quatar.api2.Utilclass.Companion.API_KEY
import com.rakibstudiohindicartoontv.quatar.model2.NewsList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {



    @GET("v2/top-headlines")
    suspend fun getBreakingNews(
        @Query("country")
        countryCode: String = "us",
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String = API_KEY
    ): Response<NewsList>



}