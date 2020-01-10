package com.example.spacex_kotlin.repository


import androidx.lifecycle.LiveData
import com.example.spacex_kotlin.repository.model.retrofit.SpacexApi
import com.example.spacex_kotlin.repository.model.room.SpacexDatabase
import com.example.spacex_kotlin.repository.model.room.events.HistoricalEvent
import com.example.spacex_kotlin.repository.model.room.launch.Launch
import com.example.spacex_kotlin.repository.model.room.mission.Mission
import com.example.spacex_kotlin.repository.model.room.roadster.Roadster
import com.example.spacex_kotlin.repository.model.room.rocket.Rocket
import com.example.spacex_kotlin.repository.model.room.rocket.RocketDetail
import com.example.spacex_kotlin.utils.makeShortDate
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class SpacexRepositoryImpl(private val api: SpacexApi, private val room: SpacexDatabase): SpacexRepository {
    private suspend fun getAllRocketsAsync() = api.getRocketsAsync()
    private suspend fun getAllEventsAsync() = api.getHistoricalEvents()
    private suspend fun getAllMissionsAsync() = api.getMissionsAsync()
    private suspend fun getAllLaunchesAsync() = api.getLaunchesAsync()

    override suspend fun populateDatabaseWithRockets(){

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

    override suspend fun populateDatabaseWithEvents(){
        val eventList = getAllEventsAsync()

        room.eventDao().addEventFromList(eventList.map {
            HistoricalEvent(it.id.toString(), it.title, it.details, it.links.article, it.links.wikipedia, makeShortDate(it.eventDateUtc))
        })
    }

    override suspend fun populateDatabaseWithMissions(){
        val missionList = getAllMissionsAsync()

        room.missionDao().addMissionFromList(missionList.map {
            Mission(it.missionId, it.missionName, it.description, it.payloadIds.joinToString(), it.website, it.wikipedia, it.manufacturers.joinToString())
        })
    }

    override suspend fun populateDatabaseWithLaunches(){
        val launchList = getAllLaunchesAsync()
        val roomList = launchList.map {
            if(it.details == null)
                Launch(it.flightNumber.toString(), it.missionName, makeShortDate(it.launchDateLocal), it.rocket.rocketName, "No Description", it.links.videoLink)
            else
                Launch(it.flightNumber.toString(), it.missionName, makeShortDate(it.launchDateLocal), it.rocket.rocketName, it.details, it.links.videoLink)
        }
        room.launchDao().addLaunchesFromList(roomList)
    }

    override suspend fun populateDatabaseWithRoadster(){
        val roadster = api.getRoadsterAsync()

        room.roadsterDao().addRoadster(Roadster(roadster.name, makeShortDate(roadster.launchDateUtc), roadster.launchMassKg.toString(), roadster.periodDays,
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

    override fun getMissionsFromDatabase(): LiveData<List<Mission>> {
        GlobalScope.launch {
            populateDatabaseWithMissions()
        }
        return room.missionDao().getAllMissions()

    }

    override fun getMissionDetailFromDatabase(id: String): LiveData<Mission> {
        return room.missionDao().getMissionDetail(id)
    }

    override fun getLaunchesFromDatabase(): LiveData<List<Launch>> {
        GlobalScope.launch {
            populateDatabaseWithLaunches()
        }
        return room.launchDao().getLaunches()
    }

    override fun getLaunchDetailFromDatabase(id: String): LiveData<Launch> {
        return room.launchDao().getLaunchDetail(id)
    }

    override suspend fun populateDatabaseWithRetrofit() = withContext(Dispatchers.IO){
        populateDatabaseWithEvents()
        populateDatabaseWithLaunches()
        populateDatabaseWithMissions()
        populateDatabaseWithRoadster()
        populateDatabaseWithRockets()
    }


}