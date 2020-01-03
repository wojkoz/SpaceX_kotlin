package com.example.spacex_kotlin.repository.model.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SpacexDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addRocket(rocket: Rocket)

    @Query("SELECT * FROM rocket_table")
    fun getRockets(): LiveData<List<Rocket>>

    @Query("DELETE FROM rocket_table")
    fun deleteAllRockets()
}