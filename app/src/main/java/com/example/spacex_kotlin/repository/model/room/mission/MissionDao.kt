package com.example.spacex_kotlin.repository.model.room.mission

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MissionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMissionFromList(mission: List<Mission>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMission(mission: Mission)

    @Query("SELECT * FROM mission_table")
    suspend fun getAllMissions(): List<Mission>

    @Query("SELECT * FROM mission_table where mission_id like :id")
    suspend fun getMissionDetail(id: String): Mission
}