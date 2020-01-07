package com.example.spacex_kotlin.repository.model.retrofit


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DiameterX(
    @Json(name = "feet")
    val feet: Any?,
    @Json(name = "meters")
    val meters: Any?
)