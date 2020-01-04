package com.example.spacex_kotlin.repository.model.retrofit


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class OrbitParamsX(
    @Json(name = "apoapsis_km")
    val apoapsisKm: Int,
    @Json(name = "arg_of_pericenter")
    val argOfPericenter: Any?,
    @Json(name = "eccentricity")
    val eccentricity: Any?,
    @Json(name = "epoch")
    val epoch: Any?,
    @Json(name = "inclination_deg")
    val inclinationDeg: Int,
    @Json(name = "lifespan_years")
    val lifespanYears: Any?,
    @Json(name = "longitude")
    val longitude: Any?,
    @Json(name = "mean_anomaly")
    val meanAnomaly: Any?,
    @Json(name = "mean_motion")
    val meanMotion: Any?,
    @Json(name = "periapsis_km")
    val periapsisKm: Int,
    @Json(name = "period_min")
    val periodMin: Any?,
    @Json(name = "raan")
    val raan: Any?,
    @Json(name = "reference_system")
    val referenceSystem: String,
    @Json(name = "regime")
    val regime: String,
    @Json(name = "semi_major_axis_km")
    val semiMajorAxisKm: Any?
)