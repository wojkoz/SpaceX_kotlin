package com.example.spacex_kotlin.repository.model.retrofit


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LaunchSiteX(
    @Json(name = "site_id")
    val siteId: String,
    @Json(name = "site_name")
    val siteName: String,
    @Json(name = "site_name_long")
    val siteNameLong: String
)