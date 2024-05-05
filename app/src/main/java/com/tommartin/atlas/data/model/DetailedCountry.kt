package com.tommartin.atlas.data.model

import com.tommartin.atlas.data.model.submodels.CountryName
import com.tommartin.atlas.data.model.submodels.Flags
import kotlinx.serialization.Serializable

@Serializable
data class DetailedCountry(
    val name: CountryName,
    val independent: Boolean,
    val capital: List<String>,
    val region: String,
    val population: Int,
    val timezones: List<String>,
    val continents: List<String>,
    val flags: Flags,
)
