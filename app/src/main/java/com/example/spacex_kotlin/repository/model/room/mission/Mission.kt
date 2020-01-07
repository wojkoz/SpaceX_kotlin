package com.example.spacex_kotlin.repository.model.room.mission

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mission_table")
data class Mission(
    @PrimaryKey @ColumnInfo(name = "mission_id") val missionId: String,
    @ColumnInfo(name = "mission_title") val missionTitle: String,
    @ColumnInfo(name = "mission_details") val missionDetails: String,
    @ColumnInfo(name = "mission_payload") val missionPayload: String,
    @ColumnInfo(name = "mission_website") val missionWebsite: String?,
    @ColumnInfo(name = "mission_wikipedia") val missionWikipedia: String?,
    @ColumnInfo(name = "mission_producent") val missionProducent: String
)