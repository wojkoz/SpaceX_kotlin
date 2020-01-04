package com.example.spacex_kotlin.repository.model.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.spacex_kotlin.repository.model.room.rocket.Rocket
import com.example.spacex_kotlin.repository.model.room.rocket.RocketDao
import com.example.spacex_kotlin.repository.model.room.rocket.RocketDetail

@Database(entities = [Rocket::class, RocketDetail::class], version = 2, exportSchema = false)
abstract class SpacexDatabase : RoomDatabase(){

    abstract fun rocketDao(): RocketDao

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


