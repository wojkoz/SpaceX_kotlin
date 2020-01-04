package com.example.spacex_kotlin.repository.model.retrofit


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CoreX(
    @Json(name = "block")
    val block: Any?,
    @Json(name = "core_serial")
    val coreSerial: String,
    @Json(name = "flight")
    val flight: Int,
    @Json(name = "gridfins")
    val gridfins: Boolean,
    @Json(name = "land_success")
    val landSuccess: Any?,
    @Json(name = "landing_intent")
    val landingIntent: Boolean,
    @Json(name = "landing_type")
    val landingType: Any?,
    @Json(name = "landing_vehicle")
    val landingVehicle: Any?,
    @Json(name = "legs")
    val legs: Boolean,
    @Json(name = "reused")
    val reused: Boolean
)