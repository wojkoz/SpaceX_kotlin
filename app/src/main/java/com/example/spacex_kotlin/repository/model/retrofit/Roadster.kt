package com.example.spacex_kotlin.repository.model.retrofit


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Roadster(
    @Json(name = "apoapsis_au")
    val apoapsisAu: Double,
    @Json(name = "details")
    val details: String,
    @Json(name = "earth_distance_km")
    val earthDistanceKm: Double,
    @Json(name = "earth_distance_mi")
    val earthDistanceMi: Double,
    @Json(name = "eccentricity")
    val eccentricity: Double,
    @Json(name = "epoch_jd")
    val epochJd: Double,
    @Json(name = "flickr_images")
    val flickrImages: List<String>,
    @Json(name = "inclination")
    val inclination: Double,
    @Json(name = "launch_date_unix")
    val launchDateUnix: Int,
    @Json(name = "launch_date_utc")
    val launchDateUtc: String,
    @Json(name = "launch_mass_kg")
    val launchMassKg: Int,
    @Json(name = "launch_mass_lbs")
    val launchMassLbs: Int,
    @Json(name = "longitude")
    val longitude: Double,
    @Json(name = "mars_distance_km")
    val marsDistanceKm: Double,
    @Json(name = "mars_distance_mi")
    val marsDistanceMi: Double,
    @Json(name = "name")
    val name: String,
    @Json(name = "norad_id")
    val noradId: Int,
    @Json(name = "orbit_type")
    val orbitType: String,
    @Json(name = "periapsis_arg")
    val periapsisArg: Double,
    @Json(name = "periapsis_au")
    val periapsisAu: Double,
    @Json(name = "period_days")
    val periodDays: Double,
    @Json(name = "semi_major_axis_au")
    val semiMajorAxisAu: Double,
    @Json(name = "speed_kph")
    val speedKph: Double,
    @Json(name = "speed_mph")
    val speedMph: Double,
    @Json(name = "wikipedia")
    val wikipedia: String
)