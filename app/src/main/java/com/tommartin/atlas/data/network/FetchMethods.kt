package com.tommartin.atlas.data.network

import io.ktor.client.HttpClient
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.flow.Flow

interface FetchMethods {
    suspend fun queryAllCountries(client: HttpClient): Flow<HttpResponse>

    // The identifier is the official name
    suspend fun querySpecificCountry(client: HttpClient, identifier: String): Flow<HttpResponse>
}