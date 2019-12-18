package com.example.spacex_kotlin.repository.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SecondStage(
    @Json(name = "burn_time_sec")
    val burnTimeSec: Int,
    @Json(name = "engines")
    val engines: Int,
    @Json(name = "fuel_amount_tons")
    val fuelAmountTons: Int,
    @Json(name = "payloads")
    val payloads: Payloads,
    @Json(name = "thrust")
    val thrust: Thrust
)