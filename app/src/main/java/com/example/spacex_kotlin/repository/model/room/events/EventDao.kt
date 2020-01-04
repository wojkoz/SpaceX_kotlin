package com.example.spacex_kotlin.repository.model.room.events

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.spacex_kotlin.repository.model.retrofit.HistoricalEvent

@Dao
interface EventDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addEventFromList(events: List<HistoricalEvent>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addEvent(event: HistoricalEvent)

    @Query("SELECT * from historical_event_table")
    fun getEvents(): List<HistoricalEvent>

    @Query("SELECT * from historical_event_detail_table")
    fun getEventDetail(id: String): List<HistoricalEventDetail>
}