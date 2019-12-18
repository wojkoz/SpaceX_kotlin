package com.example.spacex_kotlin.repository

class SpacexRepository(private val api: SpacexApi) {
    fun getAllRockets() = api.getRockets()
}