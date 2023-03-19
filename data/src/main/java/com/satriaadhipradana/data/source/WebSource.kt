package com.satriaadhipradana.data.source

import com.satriaadhipradana.data.ktor.KtorSource
import com.satriaadhipradana.data.model.*
import io.ktor.client.call.body
import io.ktor.client.request.get

class WebSource: KtorSource() {
    
    suspend fun getFlashSale() = client.get(
        "$host/a9ceeb6e-416d-4352-bde6-2203416576ac"
    ).body<FlashSaleResponse>().map()
    
    suspend fun getLatest() = client.get(
        "$host/cc0071a1-f06e-48fa-9e90-b1c2a61eaca7"
    ).body<LatestResponse>().map()
    
    suspend fun search() = client.get(
        "$host/4c9cd822-9479-4509-803d-63197e5a9e19"
    ).body<SearchResult>().words
    
    suspend fun getProduct() = client.get(
        "$host/f7f99d04-4971-45d5-92e0-70333383c239"
    ).body<FullProduct>().map()
}