package com.example.spacex_kotlin.repository.model.room.rocket

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RocketDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addRocket(rocket: Rocket)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addRocketsFromList(rockets: List<Rocket>)

    @Query("SELECT * FROM rocket_table")
    fun getRockets(): LiveData<List<Rocket>>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addRocketDetail(rocketDetail: RocketDetail)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addRocketDetailFromList(rocketDetail: List<RocketDetail>)

    @Query("SELECT * FROM rocket_detail_table WHERE rocket_id like :id")
    fun getRocketDetail(id: String): LiveData<RocketDetail>

}