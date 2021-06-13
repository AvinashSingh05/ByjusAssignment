package com.byjusassignement.api.service

import com.byjusassignement.model.network.NewsResponse
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET

interface NewsService {

    @GET("top-headlines?sources=techcrunch")
    suspend fun fetchNewList(): ApiResponse<NewsResponse>

}