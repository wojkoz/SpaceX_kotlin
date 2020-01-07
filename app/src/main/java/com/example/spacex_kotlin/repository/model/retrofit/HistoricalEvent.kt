package com.example.spacex_kotlin.repository.model.retrofit


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HistoricalEvent(
    @Json(name = "details")
    val details: String,
    @Json(name = "event_date_unix")
    val eventDateUnix: Int,
    @Json(name = "event_date_utc")
    val eventDateUtc: String,
    @Json(name = "flight_number")
    val flightNumber: Int?,
    @Json(name = "id")
    val id: Int,
    @Json(name = "links")
    val links: LinksXX,
    @Json(name = "title")
    val title: String
)