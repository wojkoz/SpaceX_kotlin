package com.example.spacex_kotlin.repository.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PayloadWeight(
    @Json(name = "id")
    val id: String,
    @Json(name = "kg")
    val kg: Int,
    @Json(name = "lb")
    val lb: Int,
    @Json(name = "name")
    val name: String
)