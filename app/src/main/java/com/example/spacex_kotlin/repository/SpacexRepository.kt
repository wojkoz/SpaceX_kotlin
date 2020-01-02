package com.example.spacex_kotlin.repository

class SpacexRepository(private val api: SpacexApi) {
    fun getAllRocketsAsync() = api.getRocketsAsync()
    fun getRocketDetailAsync(id: String) = api.getRocketDetailAsync(id)
}