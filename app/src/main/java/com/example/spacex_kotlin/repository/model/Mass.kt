package com.example.spacex_kotlin.repository.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Mass(
    @Json(name = "kg")
    val kg: Double,
    @Json(name = "lb")
    val lb: Double
)