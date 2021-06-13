package com.byjusassignement.repository

import androidx.annotation.WorkerThread
import com.byjusassignement.api.service.NewsService
import com.byjusassignement.room.NewsDao
import com.skydoves.sandwich.suspendOnSuccess
import com.skydoves.whatif.whatIfNotNull
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class NewRepository constructor(
    private val discoverService: NewsService,
    private val newsDao: NewsDao,
) : Repository{

    @WorkerThread
    fun loadNews(success: () -> Unit) = flow {
        val news = newsDao.getNewsList()
        if(news.isEmpty()) {
            val response = discoverService.fetchNewList()
            response.suspendOnSuccess {
                data.whatIfNotNull { data ->
                    newsDao.insertNewsList(data.articles)
                    emit(data.articles)
                    success()
                }
            }
        }else{
            emit(news)
            success()
        }
    }.flowOn(Dispatchers.IO)
}