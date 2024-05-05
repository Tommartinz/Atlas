package com.tommartin.atlas.data.repository

import com.tommartin.atlas.data.network.FetchMethods
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse

class AtlasRepository: FetchMethods {
    override suspend fun queryAllCountries(client: HttpClient): HttpResponse {
        return client.get("https://restcountries.com/v3.1/all")
    }

    override suspend fun querySpecificCountry(client: HttpClient, identifier: String): HttpResponse {
        return client.get("https://restcountries.com/v3.1/name/${identifier}")
    }
}