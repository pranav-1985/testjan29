package com.example.testjan29.api

import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("news")
    suspend fun getNewsInfo(
        @Query("access_key") apiKey: String = Constants.API_KEY,
        @Query("sources") sources: String,
        @Query("countries") countries: String
    ): NewsEntity
}