package com.example.spacex_kotlin.repository

class SpacexRepository(private val api: SpacexApi) {
    suspend fun getAllRocketsAsync() = api.getRocketsAsync()
    suspend fun getRocketDetailAsync(id: String) = api.getRocketDetailAsync(id)
}