package com.tommartin.atlas.data.model.submodels

import kotlinx.serialization.Serializable

@Serializable
data class CountryName(
    val common: String,
    val official: String
)
