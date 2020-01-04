package com.example.spacex_kotlin.repository


import androidx.lifecycle.LiveData
import com.example.spacex_kotlin.repository.model.SpacexDatabase
import com.example.spacex_kotlin.repository.model.room.Rocket


class SpacexRepository(private val api: SpacexApi, private val room: SpacexDatabase) {
    private suspend fun getAllRocketsAsync() = api.getRocketsAsync()
    suspend fun getRocketDetailAsync(id: String) = api.getRocketDetailAsync(id)

    //use only when app starts for first time or once a week
    suspend fun insertToDatabase(){
        room.spacexDao().addRocketsFromList(getAllRocketsAsync().map {
                Rocket(it.rocketId, it.rocketName, it.description)
            }
        )
    }
    fun getRocketsFromDatabase(): LiveData<List<Rocket>>?{
        return room.spacexDao().getRockets()
    }
}