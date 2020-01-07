package com.example.spacex_kotlin.repository.model.retrofit


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Diameter(
    @Json(name = "feet")
    val feet: Double,
    @Json(name = "meters")
    val meters: Double
)