package com.tommartin.atlas.ui

import androidx.lifecycle.ViewModel
import com.tommartin.atlas.data.model.BasicCountry
import com.tommartin.atlas.data.model.DetailedCountry
import com.tommartin.atlas.data.repository.AtlasRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

data class UIState(
    val basicCountry: List<BasicCountry>? = null,
    val detailedCountry: List<DetailedCountry>? = null,
    val query: String = "",
    val queryResult: List<BasicCountry>? = null
)

@HiltViewModel
class AtlasViewModel @Inject constructor(private val client: HttpClient) : ViewModel() {

    private val _uiState = MutableStateFlow(UIState())
    val uiState: StateFlow<UIState> = _uiState.asStateFlow()

    suspend fun getAllCountries() {
        AtlasRepository().queryAllCountries(client).collect { response ->
            _uiState.update { currentState ->
                currentState.copy(
                    basicCountry = response.body()
                )
            }
        }
    }

    suspend fun getDetailedCountry(identifier: String) {
        AtlasRepository().querySpecificCountry(client, identifier).collect { response ->
            _uiState.update { currentState ->
                currentState.copy(
                    detailedCountry = response.body()
                )
            }
        }
    }

    suspend fun getCountriesByName(query: String) {
        AtlasRepository().querySpecificCountry(client, query).collect { response ->
            _uiState.update { currentState ->
                currentState.copy(
                    query = query,
                    queryResult = response.body()
                )
            }
        }
    }
}