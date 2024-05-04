package com.tommartin.atlas.data.repository

import com.tommartin.atlas.data.network.FetchMethods
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse

class AtlasRepository: FetchMethods {
    override suspend fun queryAllCountries(client: HttpClient): HttpResponse {
        return client.get(Endpoints.ALLCOUNTRIES.url)
    }
}