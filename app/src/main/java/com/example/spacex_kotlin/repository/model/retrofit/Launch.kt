package com.example.spacex_kotlin.repository.model.retrofit


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Launch(
    @Json(name = "crew")
    val crew: Any?,
    @Json(name = "details")
    val details: String?,
    @Json(name = "flight_number")
    val flightNumber: Int,
    @Json(name = "launch_date_local")
    val launchDateLocal: String,
    @Json(name = "launch_date_unix")
    val launchDateUnix: Int,
    @Json(name = "launch_date_utc")
    val launchDateUtc: String,
    @Json(name = "launch_site")
    val launchSite: LaunchSiteX,
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
    @Json(name = "upcoming")
    val upcoming: Boolean
)