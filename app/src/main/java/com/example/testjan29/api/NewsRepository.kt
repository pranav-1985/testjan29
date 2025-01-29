package com.example.testjan29.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsRepository {

    suspend fun getNewsInfo(country: String, source: String): List<NewsModel> {

        val api = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build()
            .create(NewsApi::class.java)

        val response = api.getNewsInfo(
            sources = source,
            countries = country
        )
        return response.toNewsModel()
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
