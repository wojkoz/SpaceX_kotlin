package com.example.spacex_kotlin.repository.model.retrofit


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Mission(
    @Json(name = "description")
    val description: String,
    @Json(name = "manufacturers")
    val manufacturers: List<String>,
    @Json(name = "mission_id")
    val missionId: String,
    @Json(name = "mission_name")
    val missionName: String,
    @Json(name = "payload_ids")
    val payloadIds: List<String>,
    @Json(name = "twitter")
    val twitter: String?,
    @Json(name = "website")
    val website: String?,
    @Json(name = "wikipedia")
    val wikipedia: String?
)