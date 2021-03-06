package com.example.spacex_kotlin.repository.model.retrofit


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RocketX(
    @Json(name = "fairings")
    val fairings: Fairings,
    @Json(name = "first_stage")
    val firstStage: FirstStageX,
    @Json(name = "rocket_id")
    val rocketId: String,
    @Json(name = "rocket_name")
    val rocketName: String,
    @Json(name = "rocket_type")
    val rocketType: String,
    @Json(name = "second_stage")
    val secondStage: SecondStageX
)