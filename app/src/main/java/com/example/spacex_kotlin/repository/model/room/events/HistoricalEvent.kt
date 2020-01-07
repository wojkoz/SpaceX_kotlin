package com.example.spacex_kotlin.repository.model.room.events

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "historical_event_table")
data class HistoricalEvent(
    @PrimaryKey @ColumnInfo(name = "event_id") val eventId: String,
    @ColumnInfo(name = "event_title") val eventTitle: String,
    @ColumnInfo(name = "event_description") val eventDescription: String,
    @ColumnInfo(name = "event_spacex_link") val eventSpacexLink: String?,
    @ColumnInfo(name = "event_wikipedia_link") val eventWikipediaLink: String?,
    @ColumnInfo(name = "event_date") val eventDate: String?
)