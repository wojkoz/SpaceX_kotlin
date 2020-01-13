package com.example.spacex_kotlin.repository.model.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.spacex_kotlin.repository.model.room.events.EventDao
import com.example.spacex_kotlin.repository.model.room.events.HistoricalEvent
import com.example.spacex_kotlin.repository.model.room.launch.Launch
import com.example.spacex_kotlin.repository.model.room.launch.LaunchDao
import com.example.spacex_kotlin.repository.model.room.mission.Mission
import com.example.spacex_kotlin.repository.model.room.mission.MissionDao
import com.example.spacex_kotlin.repository.model.room.roadster.Roadster
import com.example.spacex_kotlin.repository.model.room.roadster.RoadsterDao
import com.example.spacex_kotlin.repository.model.room.rocket.Rocket
import com.example.spacex_kotlin.repository.model.room.rocket.RocketDao
import com.example.spacex_kotlin.repository.model.room.rocket.RocketDetail

@Database(entities = [Rocket::class, RocketDetail::class, Roadster::class, HistoricalEvent::class, Mission::class, Launch::class], version = 10, exportSchema = false)
abstract class SpacexDatabase : RoomDatabase(){

    abstract fun rocketDao(): RocketDao
    abstract  fun eventDao(): EventDao
    abstract  fun roadsterDao(): RoadsterDao
    abstract  fun missionDao(): MissionDao
    abstract  fun launchDao(): LaunchDao

    companion object {

        @Volatile
        private var INSTANCE: SpacexDatabase? = null

        fun getDatabase(context: Context): SpacexDatabase? {
            if (INSTANCE == null) {
                synchronized(SpacexDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            SpacexDatabase::class.java, "spacex_database"
                        )
                            .fallbackToDestructiveMigration()
                            .build()
                    }
                }
            }
            return INSTANCE
        }
    }
}


