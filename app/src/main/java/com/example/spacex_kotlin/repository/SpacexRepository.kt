package com.example.spacex_kotlin.repository

import androidx.lifecycle.LiveData
import com.example.spacex_kotlin.repository.model.room.rocket.Rocket
import com.example.spacex_kotlin.repository.model.room.rocket.RocketDetail

interface SpacexRepository {
    fun getRocketsFromDatabase(): LiveData<List<Rocket>>?
    fun getRocketDetailFromDatabase(id: String): LiveData<RocketDetail>

}