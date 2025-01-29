package com.example.testjan29.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsRepository {

    suspend fun getCurrencyInfo(country: String, source: String): List<NewsModel> {

        // Retrofit instance setup
        val api = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)  // Use the base URL constant
            .build()
            .create(NewsApi::class.java)  // Create the API service interface

        // Making the network call and converting the response to a list
        try{
            val response = api.getNewsInfo(
                accessKey = Constants.API_KEY,
                source,
                country
            )
          return  response.toNewsModel()
        } catch ( e : Exception){
            e.printStackTrace()

        }

        return emptyList()
    }
}

fun NewsEntity.toNewsModel(): List<NewsModel> {
    // Map each article in the data list to a NewsModel object
    return this.data.map { article ->
        NewsModel(
            newsTitle = article.title,
            newsDescription = article.description,
            newsSource = article.source
        )
    }
}
//
//fun NewsEntity.filterOnSourceAndCountry(country: String, source: String): List<NewsModel> {
//
//    val newsModels = this.toNewsModel()
//
//    return newsModels.filter { newsModel ->
//        newsModel.newsSource == source && newsModel.newsDescription.contains(
//            country,
//            ignoreCase = true
//        )
//    }
//}
