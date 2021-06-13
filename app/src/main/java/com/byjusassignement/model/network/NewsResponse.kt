package com.byjusassignement.model.network

import com.byjusassignement.model.NetworkResponseModel
import com.byjusassignement.model.News

data class NewsResponse(
    val articles: List<News>,
) : NetworkResponseModel
