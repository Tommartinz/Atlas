package com.tommartin.atlas.data.network

import io.ktor.client.HttpClient
import io.ktor.client.statement.HttpResponse

interface FetchMethods {
    suspend fun queryAllCountries(client: HttpClient): HttpResponse

    // The identifier is the official name
    suspend fun querySpecificCountry(client: HttpClient, identifier: String): HttpResponse
}