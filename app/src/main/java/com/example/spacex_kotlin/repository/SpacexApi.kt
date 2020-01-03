package com.example.spacex_kotlin.repository

import com.example.spacex_kotlin.repository.model.retrofit.Rocket


import retrofit2.http.GET
import retrofit2.http.Path

interface SpacexApi {

    @GET("rockets")
    suspend fun getRocketsAsync(): List<Rocket>

    @GET("rockets/{id}")
    suspend fun getRocketDetailAsync(@Path("id") id: String): Rocket
}