package com.example.spacex_kotlin.repository


import androidx.lifecycle.LiveData
import com.example.spacex_kotlin.repository.model.retrofit.SpacexApi
import com.example.spacex_kotlin.repository.model.room.SpacexDatabase
import com.example.spacex_kotlin.repository.model.room.rocket.Rocket
import com.example.spacex_kotlin.repository.model.room.rocket.RocketDetail
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class SpacexRepositoryImpl(private val api: SpacexApi, private val room: SpacexDatabase): SpacexRepository {
    suspend fun getAllRocketsAsync() = api.getRocketsAsync()

    //use only when app starts for first time or once a week
    suspend fun insertToDatabase(){

        val rocketList = getAllRocketsAsync()

        room.rocketDao().addRocketsFromList(rocketList.map {
            Rocket(
                it.rocketId,
                it.rocketName,
                it.description
            )
            }
        )

        room.rocketDao().addRocketDetailFromList(rocketList.map {
            RocketDetail(
                it.rocketId,
                it.rocketName,
                it.rocketType,
                it.mass.kg.toString(),
                it.diameter.meters.toString(),
                it.height.meters.toString(),
                it.costPerLaunch.toString(),
                it.firstFlight,
                it.description
            )
        })
    }
    override fun getRocketsFromDatabase(): LiveData<List<Rocket>>?{
        GlobalScope.launch {
            insertToDatabase()
        }

        return room.rocketDao().getRockets()
    }

    override fun getRocketDetailFromDatabase(id: String): LiveData<RocketDetail> {
        return room.rocketDao().getRocketDetail(id)
    }
}