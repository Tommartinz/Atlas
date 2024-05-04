package com.tommartin.atlas.data.model.submodels

import kotlinx.serialization.Serializable

@Serializable
data class Flags(
    val svg: String,
    val alt: String
)
