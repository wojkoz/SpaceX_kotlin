package com.example.spacex_kotlin.repository.model.room.mission

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MissionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addMissionFromList(mission: List<Mission>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addMission(mission: Mission)

    @Query("SELECT * FROM mission_table")
    fun getAllMissions(): LiveData<List<Mission>>

    @Query("SELECT * FROM mission_table where mission_id like :id")
    fun getMissionDetail(id: String): LiveData<Mission>
}