package com.example.spacex_kotlin.repository.model.retrofit


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Engines(
    @Json(name = "engine_loss_max")
    val engineLossMax: Any?,
    @Json(name = "layout")
    val layout: Any?,
    @Json(name = "number")
    val number: Int,
    @Json(name = "propellant_1")
    val propellant1: String,
    @Json(name = "propellant_2")
    val propellant2: String,
    @Json(name = "thrust_sea_level")
    val thrustSeaLevel: ThrustSeaLevel,
    @Json(name = "thrust_to_weight")
    val thrustToWeight: Any?,
    @Json(name = "thrust_vacuum")
    val thrustVacuum: ThrustVacuum,
    @Json(name = "type")
    val type: String,
    @Json(name = "version")
    val version: String
)