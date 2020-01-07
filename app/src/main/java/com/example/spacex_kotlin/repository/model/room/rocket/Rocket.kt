package com.example.spacex_kotlin.repository.model.room.rocket

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "rocket_table")
data class Rocket(
    @PrimaryKey @ColumnInfo(name = "rocket_id") val rocketId: String,
    @ColumnInfo(name = "rocket_name") val rocketName: String?,
    @ColumnInfo(name = "description") val description: String?
)