package com.example.spacex_kotlin.repository.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Rocket(
    @Json(name = "active")
    val active: Boolean,
    @Json(name = "boosters")
    val boosters: Int,
    @Json(name = "company")
    val company: String,
    @Json(name = "cost_per_launch")
    val costPerLaunch: Int,
    @Json(name = "country")
    val country: String,
    @Json(name = "description")
    val description: String,
    @Json(name = "diameter")
    val diameter: Diameter,
    @Json(name = "engines")
    val engines: Engines,
    @Json(name = "first_flight")
    val firstFlight: String,
    @Json(name = "first_stage")
    val firstStage: FirstStage,
    @Json(name = "height")
    val height: Height,
    @Json(name = "id")
    val id: Int,
    @Json(name = "landing_legs")
    val landingLegs: LandingLegs,
    @Json(name = "mass")
    val mass: Mass,
    @Json(name = "payload_weights")
    val payloadWeights: List<PayloadWeight>,
    @Json(name = "rocket_id")
    val rocketId: String,
    @Json(name = "rocket_name")
    val rocketName: String,
    @Json(name = "rocket_type")
    val rocketType: String,
    @Json(name = "second_stage")
    val secondStage: SecondStage,
    @Json(name = "stages")
    val stages: Int,
    @Json(name = "success_rate_pct")
    val successRatePct: Int,
    @Json(name = "wikipedia")
    val wikipedia: String
)