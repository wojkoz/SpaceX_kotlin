package com.example.spacex_kotlin.repository

class SpacexRepository(private val api: SpacexApi) {
    suspend fun getAllRockets() = api.getRockets()
}