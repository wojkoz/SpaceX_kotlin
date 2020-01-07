package com.example.spacex_kotlin.repository.model.retrofit


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RocketXX(

    @Json(name = "rocket_id")
    val rocketId: String,
    @Json(name = "rocket_name")
    val rocketName: String,
    @Json(name = "rocket_type")
    val rocketType: String

)