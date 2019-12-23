package com.example.spacex_kotlin.repository.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SecondStage(
    @Json(name = "burn_time_sec")
    val burnTimeSec: Double?,
    @Json(name = "engines")
    val engines: Double,
    @Json(name = "fuel_amount_tons")
    val fuelAmountTons: Double,
    @Json(name = "payloads")
    val payloads: Payloads,
    @Json(name = "thrust")
    val thrust: Thrust
)