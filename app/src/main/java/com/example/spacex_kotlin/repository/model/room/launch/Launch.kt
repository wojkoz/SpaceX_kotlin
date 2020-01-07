package com.example.spacex_kotlin.repository.model.room.launch

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "launch_table")
data class Launch(
    @PrimaryKey @ColumnInfo(name = "launch_id") val launchId: String,
    @ColumnInfo(name = "launch_name") val launchName: String,
    @ColumnInfo(name = "launch_start_date") val launchStartDate: String,
    @ColumnInfo(name = "launch_rocket") val launchRocketName: String,
    @ColumnInfo(name = "launch_description") val launchDescription: String,
    @ColumnInfo(name = "launch_video_link") val launchVideoLink: String?
)