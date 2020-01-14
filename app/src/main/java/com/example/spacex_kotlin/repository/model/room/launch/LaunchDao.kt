package com.example.spacex_kotlin.repository.model.room.launch

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface LaunchDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addLaunchesFromList(launch: List<Launch>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addLaunch(launch:Launch)

    @Query("SELECT * FROM launch_table")
    suspend fun getLaunches(): List<Launch>

    @Query("SELECT * FROM launch_table where launch_id like :id")
    suspend fun getLaunchDetail(id: String): Launch
}