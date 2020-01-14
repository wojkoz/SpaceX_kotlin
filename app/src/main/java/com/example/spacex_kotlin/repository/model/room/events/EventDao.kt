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

    @Query("SELECT * from historical_event_table")
    suspend fun getEvents(): List<HistoricalEvent>

    @Query("SELECT * from historical_event_table WHERE event_id like :id")
    suspend fun getEventDetail(id: String): HistoricalEvent
}