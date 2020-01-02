package com.example.spacex_kotlin.repository

import com.example.spacex_kotlin.repository.model.Rocket
import kotlinx.coroutines.Deferred
import retrofit2.Response


import retrofit2.http.GET
import retrofit2.http.Path

interface SpacexApi {

    @GET("rockets")
    fun getRocketsAsync(): Deferred<Response<List<Rocket>>>

    @GET("rockets/{id}")
    fun getRocketDetailAsync(@Path("id") id: String): Deferred<Response<Rocket>>
}