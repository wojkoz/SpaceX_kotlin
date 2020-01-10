package com.example.spacex_kotlin.repository

import androidx.lifecycle.LiveData
import com.example.spacex_kotlin.repository.model.room.events.HistoricalEvent
import com.example.spacex_kotlin.repository.model.room.launch.Launch
import com.example.spacex_kotlin.repository.model.room.mission.Mission
import com.example.spacex_kotlin.repository.model.room.roadster.Roadster
import com.example.spacex_kotlin.repository.model.room.rocket.Rocket
import com.example.spacex_kotlin.repository.model.room.rocket.RocketDetail

interface SpacexRepository {
    fun getRocketsFromDatabase(): LiveData<List<Rocket>>?
    fun getRocketDetailFromDatabase(id: String): LiveData<RocketDetail>

    fun getEventsFromDatabase(): LiveData<List<HistoricalEvent>>
    fun getEventDetailFromDatabase(id: String): LiveData<HistoricalEvent>

    fun getRoadster(): LiveData<Roadster>

    fun getMissionsFromDatabase(): LiveData<List<Mission>>
    fun getMissionDetailFromDatabase(id: String): LiveData<Mission>

    fun getLaunchesFromDatabase(): LiveData<List<Launch>>
    fun getLaunchDetailFromDatabase(id: String): LiveData<Launch>

    //update all data
    suspend fun populateDatabaseWithRetrofit()

    //update particular data
    suspend fun populateDatabaseWithEvents()
    suspend fun populateDatabaseWithMissions()
    suspend fun populateDatabaseWithLaunches()
    suspend fun populateDatabaseWithRoadster()
    suspend fun populateDatabaseWithRockets()

}