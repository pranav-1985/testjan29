package com.example.testjan29.api

import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("news")  // The endpoint path (after the base URL)
    suspend fun getNewsInfo(
        @Query("access_key") accessKey: String,
        @Query("source") source: String,
        @Query("country") country: String
    ): NewsEntity
}