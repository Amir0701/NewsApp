package com.example.newsapp.repositories

import com.example.newsapp.api.RetrofitInstance
import com.example.newsapp.database.ArticleDatabase
import com.example.newsapp.entities.Article

class NewsRepository (val db: ArticleDatabase){
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun getSearchNews(queryString: String, pageNumber: Int) =
            RetrofitInstance.api.searchForNews(queryString, pageNumber)

    suspend fun upsert(article: Article) = db.getDao().upsert(article)

    fun getSavedNews() = db.getDao().getAllArticles()

    suspend fun delete(article: Article) = db.getDao().deleteArticle(article)
}