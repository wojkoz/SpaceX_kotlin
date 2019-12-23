package com.example.spacex_kotlin.repository.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FirstStage(
    @Json(name = "burn_time_sec")
    val burnTimeSec: Double?,
    @Json(name = "engines")
    val engines: Double,
    @Json(name = "fuel_amount_tons")
    val fuelAmountTons: Double,
    @Json(name = "reusable")
    val reusable: Boolean,
    @Json(name = "thrust_sea_level")
    val thrustSeaLevel: ThrustSeaLevelX,
    @Json(name = "thrust_vacuum")
    val thrustVacuum: ThrustVacuumX
)