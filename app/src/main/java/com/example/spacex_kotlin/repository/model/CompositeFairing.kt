package com.example.spacex_kotlin.repository.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CompositeFairing(
    @Json(name = "diameter")
    val diameter: DiameterX,
    @Json(name = "height")
    val height: HeightX
)