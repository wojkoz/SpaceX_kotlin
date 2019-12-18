package com.example.spacex_kotlin.repository.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Diameter(
    @Json(name = "feet")
    val feet: Int,
    @Json(name = "meters")
    val meters: Double
)