package com.example.spacex_kotlin.repository.model.retrofit


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PayloadX(
    @Json(name = "customers")
    val customers: List<String>,
    @Json(name = "manufacturer")
    val manufacturer: String,
    @Json(name = "nationality")
    val nationality: String,
    @Json(name = "norad_id")
    val noradId: List<Any>,
    @Json(name = "orbit")
    val orbit: String,
    @Json(name = "orbit_params")
    val orbitParams: OrbitParamsX,
    @Json(name = "payload_id")
    val payloadId: String,
    @Json(name = "payload_mass_kg")
    val payloadMassKg: Int,
    @Json(name = "payload_mass_lbs")
    val payloadMassLbs: Int,
    @Json(name = "payload_type")
    val payloadType: String,
    @Json(name = "reused")
    val reused: Boolean,
    @Json(name = "uid")
    val uid: String
)