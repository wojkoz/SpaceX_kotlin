package com.example.spacex_kotlin.repository.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LandingLegs(
    @Json(name = "material")
    val material: String?,
    @Json(name = "number")
    val number: Int
)