package com.example.spacex_kotlin.repository.model.room.roadster

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "roadster_table")
data class Roadster(
    @PrimaryKey @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "launch_date") val launch_date: String,
    @ColumnInfo(name = "start_mass") val mass: String,
    @ColumnInfo(name = "days_in_space") val daysInSpace: Double,
    @ColumnInfo(name = "speed") val speed: Double,
    @ColumnInfo(name = "earth_distance") val distanceFromEarth: Double,
    @ColumnInfo(name = "mars_distance") val distanceFromMars: Double,
    @ColumnInfo(name = "details") val details: String,
    @ColumnInfo(name = "wikipedia") val wikipediaLink: String
)