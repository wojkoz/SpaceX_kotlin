package com.example.spacex_kotlin.repository.model.retrofit


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LinksXX(
    @Json(name = "article")
    val article: String,
    @Json(name = "reddit")
    val reddit: Any?,
    @Json(name = "wikipedia")
    val wikipedia: String?
)