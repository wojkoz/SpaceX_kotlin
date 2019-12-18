package com.example.spacex_kotlin.repository

import com.example.spacex_kotlin.repository.model.Rocket
import retrofit2.Call
import retrofit2.http.GET

interface SpacexApi {

    @GET("rockets")
    fun getRockets(): Call<List<Rocket>>
}