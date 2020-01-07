package com.example.spacex_kotlin.repository.model.retrofit


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Timeline(
    @Json(name = "webcast_liftoff")
    val webcastLiftoff: Int
)