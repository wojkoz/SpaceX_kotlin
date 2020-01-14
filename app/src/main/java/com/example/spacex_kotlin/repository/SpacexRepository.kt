package com.example.spacex_kotlin.repository

import com.example.spacex_kotlin.repository.model.room.events.HistoricalEvent
import com.example.spacex_kotlin.repository.model.room.launch.Launch
import com.example.spacex_kotlin.repository.model.room.mission.Mission
import com.example.spacex_kotlin.repository.model.room.roadster.Roadster
import com.example.spacex_kotlin.repository.model.room.rocket.Rocket
import com.example.spacex_kotlin.repository.model.room.rocket.RocketDetail

interface SpacexRepository {
    suspend fun getRocketsFromDatabase(): List<Rocket>
    suspend fun getRocketDetailFromDatabase(id: String): RocketDetail

    suspend fun getEventsFromDatabase(): List<HistoricalEvent>
    suspend fun getEventDetailFromDatabase(id: String): HistoricalEvent

    suspend fun getRoadster(): Roadster

    suspend fun getMissionsFromDatabase(): List<Mission>
    suspend fun getMissionDetailFromDatabase(id: String): Mission

    suspend fun getLaunchesFromDatabase(): List<Launch>
    suspend fun getLaunchDetailFromDatabase(id: String): Launch

    //update all data
    suspend fun populateDatabaseWithRetrofit()

    //update particular data
    suspend fun populateDatabaseWithEvents()
    suspend fun populateDatabaseWithMissions()
    suspend fun populateDatabaseWithLaunches()
    suspend fun populateDatabaseWithRoadster()
    suspend fun populateDatabaseWithRockets()

}