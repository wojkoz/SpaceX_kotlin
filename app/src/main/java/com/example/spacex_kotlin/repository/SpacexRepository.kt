package com.example.spacex_kotlin.repository

import androidx.lifecycle.LiveData
import com.example.spacex_kotlin.repository.model.room.events.HistoricalEvent
import com.example.spacex_kotlin.repository.model.room.roadster.Roadster
import com.example.spacex_kotlin.repository.model.room.rocket.Rocket
import com.example.spacex_kotlin.repository.model.room.rocket.RocketDetail

interface SpacexRepository {
    fun getRocketsFromDatabase(): LiveData<List<Rocket>>?
    fun getRocketDetailFromDatabase(id: String): LiveData<RocketDetail>

    fun getEventsFromDatabase(): LiveData<List<HistoricalEvent>>
    fun getEventDetailFromDatabase(id: String): LiveData<HistoricalEvent>

    fun getRoadster(): LiveData<Roadster>

}