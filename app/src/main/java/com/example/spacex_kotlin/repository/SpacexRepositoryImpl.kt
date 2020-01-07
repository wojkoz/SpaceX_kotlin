package com.example.spacex_kotlin.repository


import androidx.lifecycle.LiveData
import com.example.spacex_kotlin.repository.model.retrofit.SpacexApi
import com.example.spacex_kotlin.repository.model.room.SpacexDatabase
import com.example.spacex_kotlin.repository.model.room.events.HistoricalEvent
import com.example.spacex_kotlin.repository.model.room.roadster.Roadster
import com.example.spacex_kotlin.repository.model.room.rocket.Rocket
import com.example.spacex_kotlin.repository.model.room.rocket.RocketDetail
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class SpacexRepositoryImpl(private val api: SpacexApi, private val room: SpacexDatabase): SpacexRepository {
    suspend fun getAllRocketsAsync() = api.getRocketsAsync()
    suspend fun getAllEcentsAsync() = api.getHistoricalEvents()

    //use only when app starts for first time or once a week
    private suspend fun populateDatabaseWithRockets(){

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

    private suspend fun populateDatabaseWithEvents(){
        val eventList = getAllEcentsAsync()

        room.eventDao().addEventFromList(eventList.map {
            HistoricalEvent(it.id.toString(), it.title, it.details, it.links.article, it.links.wikipedia, it.eventDateUtc)
        })
    }

    private suspend fun populateDatabaseWithRoadster(){
        val roadster = api.getRoadsterAsync()

        room.roadsterDao().addRoadster(Roadster(roadster.name, roadster.launchDateUtc, roadster.launchMassKg.toString(), roadster.periodDays,
            roadster.speedKph, roadster.earthDistanceKm, roadster.marsDistanceKm, roadster.details, roadster.wikipedia))
    }

    override fun getRocketsFromDatabase(): LiveData<List<Rocket>>?{
        GlobalScope.launch {
            populateDatabaseWithRockets()
        }

        return room.rocketDao().getRockets()
    }

    override fun getRocketDetailFromDatabase(id: String): LiveData<RocketDetail> {
        return room.rocketDao().getRocketDetail(id)
    }

    override fun getEventsFromDatabase(): LiveData<List<HistoricalEvent>> {
        GlobalScope.launch {
            populateDatabaseWithEvents()
        }
        return room.eventDao().getEvents()
    }

    override fun getEventDetailFromDatabase(id: String): LiveData<HistoricalEvent> {
        return room.eventDao().getEventDetail(id)
    }

    override fun getRoadster(): LiveData<Roadster> {
        GlobalScope.launch {
            populateDatabaseWithRoadster()
        }
        return room.roadsterDao().getRoadster()
    }
}