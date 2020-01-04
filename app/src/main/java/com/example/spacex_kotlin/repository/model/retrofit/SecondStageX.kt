package com.example.spacex_kotlin.repository.model.retrofit


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SecondStageX(
    @Json(name = "block")
    val block: Int,
    @Json(name = "payloads")
    val payloads: List<Payload>
)