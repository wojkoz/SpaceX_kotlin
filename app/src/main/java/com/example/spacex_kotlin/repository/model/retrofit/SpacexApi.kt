package com.example.spacex_kotlin.repository.model.retrofit


import retrofit2.http.GET


interface SpacexApi {

    @GET("rockets")
    suspend fun getRocketsAsync(): List<Rocket>


    @GET("missions")
    suspend fun getMissionsAsync(): List<Mission>

    @GET("roadster")
    suspend fun getRoadsterAsync(): Roadster

    @GET("launches/upcoming")
    suspend fun getUpcomingLaunchesAsync(): NextLaunch

    @GET("launches")
    suspend fun getLaunchesAsync(): List<Launch>

    @GET("history")
    suspend fun getHistoricalEvents(): List<HistoricalEvent>

}