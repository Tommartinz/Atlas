package com.tommartin.atlas.data.repository

import com.tommartin.atlas.data.network.FetchMethods
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AtlasRepository: FetchMethods {
    override suspend fun queryAllCountries(client: HttpClient): Flow<HttpResponse> {
        return flow {
            emit(client.get("https://restcountries.com/v3.1/all"))
        }
    }

    override suspend fun querySpecificCountry(client: HttpClient, identifier: String): Flow<HttpResponse> {
        return flow {
            emit(client.get("https://restcountries.com/v3.1/name/${identifier}"))
        }
    }
}