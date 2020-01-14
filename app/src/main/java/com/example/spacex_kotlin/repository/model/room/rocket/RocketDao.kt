package com.example.spacex_kotlin.repository.model.room.rocket

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RocketDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addRocket(rocket: Rocket)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addRocketsFromList(rockets: List<Rocket>)

    @Query("SELECT * FROM rocket_table")
    suspend fun getRockets(): List<Rocket>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addRocketDetail(rocketDetail: RocketDetail)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addRocketDetailFromList(rocketDetail: List<RocketDetail>)

    @Query("SELECT * FROM rocket_detail_table WHERE rocket_id like :id")
    suspend fun getRocketDetail(id: String): RocketDetail

}