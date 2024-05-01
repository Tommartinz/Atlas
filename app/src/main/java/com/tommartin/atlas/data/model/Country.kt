package com.tommartin.atlas.data.model

import com.tommartin.atlas.data.model.submodels.CountryName
import kotlinx.serialization.Serializable

@Serializable
data class Country(
    val countryName: CountryName,
    val independent: Boolean,
    val capitals: List<String>,
    val region: String,
    val area: Int,
    val population: Int,
    val timezones: List<String>,
    val continents: List<String>
)
