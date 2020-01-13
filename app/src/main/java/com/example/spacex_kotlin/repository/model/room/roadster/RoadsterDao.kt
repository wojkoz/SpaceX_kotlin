package com.example.spacex_kotlin.repository.model.room.roadster

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RoadsterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addRoadster(roadster: Roadster)

    @Query("SELECT * FROM roadster_table")
    suspend fun getRoadster(): Roadster
}