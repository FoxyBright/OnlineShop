package com.satriaadhipradana.data

import com.satriaadhipradana.data.ktor.KtorSource
import com.satriaadhipradana.data.model.LatestResponse
import com.satriaadhipradana.data.model.SaleResponse
import io.ktor.client.call.body
import io.ktor.client.request.get

class WebSource: KtorSource() {
    
    suspend fun getFlashSale() = client.get(
        "$host/a9ceeb6e-416d-4352-bde6-2203416576ac"
    ).body<SaleResponse>().map()
    
    suspend fun getLatest() = client.get(
        "$host/cc0071a1-f06e-48fa-9e90-b1c2a61eaca7"
    ).body<LatestResponse>().map()
}