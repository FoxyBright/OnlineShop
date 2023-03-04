package com.satriaadhipradana.data.ktor

import com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL
import com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.HttpRequestRetry
import io.ktor.client.plugins.UserAgent
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.ContentType.Application.Json
import io.ktor.http.contentType
import io.ktor.serialization.jackson.jackson
import java.io.IOException
import java.util.concurrent.TimeUnit

open class KtorSource {
    
    val host = "https://run.mocky.io/v3"
    
    private val baseClient by lazy {
        HttpClient(OkHttp) {
            engine { config { writeTimeout(5, TimeUnit.MINUTES) } }
            install(Logging) {
                level = LogLevel.BODY
                logger = LogAdapter
            }
            install(HttpRequestRetry) {
                exponentialDelay()
                maxRetries = 3
                retryOnExceptionIf { _, throwable -> throwable is IOException }
            }
            install(ContentNegotiation) {
                jackson {
                    configure(FAIL_ON_UNKNOWN_PROPERTIES, false)
                    propertyNamingStrategy = SnakeCaseStrategy()
                    setSerializationInclusion(NON_NULL)
                }
            }
            defaultRequest { contentType(Json); host = host }
            install(UserAgent) { agent = host }
        }
    }
    
    val client by lazy { baseClient.config {} }
}