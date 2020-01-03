package com.example.spacex_kotlin.repository.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.spacex_kotlin.repository.model.room.Rocket
import com.example.spacex_kotlin.repository.model.room.SpacexDao

@Database(entities = [Rocket::class], version = 1, exportSchema = false)
abstract class SpacexDatabase : RoomDatabase(){

    abstract fun spacexDao(): SpacexDao

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
                            .build()
                    }
                }
            }
            return INSTANCE
        }
    }
}


