package com.example.spacex_kotlin.repository

import com.example.spacex_kotlin.repository.model.Rocket
import kotlinx.coroutines.Deferred
import retrofit2.Response


import retrofit2.http.GET

interface SpacexApi {

    @GET("rockets")
    fun getRockets(): Deferred<Response<List<Rocket>>>
}