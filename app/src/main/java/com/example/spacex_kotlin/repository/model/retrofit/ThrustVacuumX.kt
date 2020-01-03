package com.example.spacex_kotlin.repository.model.retrofit


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ThrustVacuumX(
    @Json(name = "kN")
    val kN: Double,
    @Json(name = "lbf")
    val lbf: Double
)