package com.tommartin.atlas.data.model

import com.tommartin.atlas.data.model.submodels.CountryName
import com.tommartin.atlas.data.model.submodels.Flags
import kotlinx.serialization.Serializable

@Serializable
data class BasicCountry(
    val name: CountryName,
    val flags: Flags,
    val population: Int,
)
