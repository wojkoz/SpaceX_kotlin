package com.example.spacex_kotlin.repository.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HeightX(
    @Json(name = "feet")
    val feet: Any?,
    @Json(name = "meters")
    val meters: Any?
)