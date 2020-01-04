package com.example.spacex_kotlin.repository.model.retrofit


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NextLaunch(
    @Json(name = "crew")
    val crew: Any?,
    @Json(name = "details")
    val details: String,
    @Json(name = "flight_number")
    val flightNumber: Int,
    @Json(name = "is_tentative")
    val isTentative: Boolean,
    @Json(name = "last_date_update")
    val lastDateUpdate: String,
    @Json(name = "last_ll_launch_date")
    val lastLlLaunchDate: String,
    @Json(name = "last_ll_update")
    val lastLlUpdate: String,
    @Json(name = "last_wiki_launch_date")
    val lastWikiLaunchDate: String,
    @Json(name = "last_wiki_revision")
    val lastWikiRevision: String,
    @Json(name = "last_wiki_update")
    val lastWikiUpdate: String,
    @Json(name = "launch_date_local")
    val launchDateLocal: String,
    @Json(name = "launch_date_source")
    val launchDateSource: String,
    @Json(name = "launch_date_unix")
    val launchDateUnix: Int,
    @Json(name = "launch_date_utc")
    val launchDateUtc: String,
    @Json(name = "launch_site")
    val launchSite: LaunchSite,
    @Json(name = "launch_success")
    val launchSuccess: Any?,
    @Json(name = "launch_window")
    val launchWindow: Any?,
    @Json(name = "launch_year")
    val launchYear: String,
    @Json(name = "links")
    val links: Links,
    @Json(name = "mission_id")
    val missionId: List<Any>,
    @Json(name = "mission_name")
    val missionName: String,
    @Json(name = "rocket")
    val rocket: RocketX,
    @Json(name = "ships")
    val ships: List<Any>,
    @Json(name = "static_fire_date_unix")
    val staticFireDateUnix: Any?,
    @Json(name = "static_fire_date_utc")
    val staticFireDateUtc: Any?,
    @Json(name = "tbd")
    val tbd: Boolean,
    @Json(name = "telemetry")
    val telemetry: Telemetry,
    @Json(name = "tentative_max_precision")
    val tentativeMaxPrecision: String,
    @Json(name = "timeline")
    val timeline: Any?,
    @Json(name = "upcoming")
    val upcoming: Boolean
)