package com.example.spacex_kotlin.repository.model.retrofit


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LaunchFailureDetails(
    @Json(name = "altitude")
    val altitude: Any?,
    @Json(name = "reason")
    val reason: String,
    @Json(name = "time")
    val time: Int
)