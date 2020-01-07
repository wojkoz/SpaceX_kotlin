package com.example.spacex_kotlin.repository.model.room.events

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface EventDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addEventFromList(events: List<HistoricalEvent>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addEvent(event: HistoricalEvent)

    // TODO: return id title desc
    @Query("SELECT * from historical_event_table")
    fun getEvents(): LiveData<List<HistoricalEvent>>

    @Query("SELECT * from historical_event_table WHERE event_id like :id")
    fun getEventDetail(id: String): LiveData<HistoricalEvent>
}