package com.tommartin.atlas.data.network

import io.ktor.client.HttpClient
import io.ktor.client.statement.HttpResponse

interface FetchMethods {
    suspend fun queryAllCountries(client: HttpClient): HttpResponse
}