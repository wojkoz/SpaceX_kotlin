package com.example.spacex_kotlin.repository.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Payloads(
    @Json(name = "composite_fairing")
    val compositeFairing: CompositeFairing,
    @Json(name = "option_1")
    val option1: String,
    @Json(name = "option_2")
    val option2: String?
)