package com.example.spacex_kotlin.repository.model.room.launch

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface LaunchDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addLaunchesFromList(launch: List<Launch>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addLaunch(launch:Launch)

    @Query("SELECT * FROM launch_table")
    fun getLaunches(): LiveData<List<Launch>>

    @Query("SELECT * FROM launch_table where launch_id like :id")
    fun getLaunchDetail(id: String): LiveData<Launch>
}