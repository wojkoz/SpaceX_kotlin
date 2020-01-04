package com.example.spacex_kotlin.repository.model.retrofit


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Launch(
    @Json(name = "crew")
    val crew: Any?,
    @Json(name = "details")
    val details: String,
    @Json(name = "flight_number")
    val flightNumber: Int,
    @Json(name = "is_tentative")
    val isTentative: Boolean,
    @Json(name = "launch_date_local")
    val launchDateLocal: String,
    @Json(name = "launch_date_unix")
    val launchDateUnix: Int,
    @Json(name = "launch_date_utc")
    val launchDateUtc: String,
    @Json(name = "launch_failure_details")
    val launchFailureDetails: LaunchFailureDetails,
    @Json(name = "launch_site")
    val launchSite: LaunchSiteX,
    @Json(name = "launch_success")
    val launchSuccess: Boolean,
    @Json(name = "launch_window")
    val launchWindow: Int,
    @Json(name = "launch_year")
    val launchYear: String,
    @Json(name = "links")
    val links: LinksX,
    @Json(name = "mission_id")
    val missionId: List<Any>,
    @Json(name = "mission_name")
    val missionName: String,
    @Json(name = "rocket")
    val rocket: RocketXX,
    @Json(name = "ships")
    val ships: List<Any>,
    @Json(name = "static_fire_date_unix")
    val staticFireDateUnix: Int,
    @Json(name = "static_fire_date_utc")
    val staticFireDateUtc: String,
    @Json(name = "tbd")
    val tbd: Boolean,
    @Json(name = "telemetry")
    val telemetry: TelemetryX,
    @Json(name = "tentative_max_precision")
    val tentativeMaxPrecision: String,
    @Json(name = "timeline")
    val timeline: Timeline,
    @Json(name = "upcoming")
    val upcoming: Boolean
)