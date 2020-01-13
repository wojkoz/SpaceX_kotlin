package com.example.spacex_kotlin.repository.model.room.rocket

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "rocket_detail_table")
data class RocketDetail(
    @PrimaryKey @ColumnInfo(name = "rocket_id") val rocketId: String,
    @ColumnInfo(name = "rocket_name") val rocketName: String,
    @ColumnInfo(name = "rocket_type") val rocketType: String,
    @ColumnInfo(name = "rocket_first_stage") val rocketFirstStage: String,
    @ColumnInfo(name = "rocket_second_stage") val rocketSecondStage: String,
    @ColumnInfo(name = "rocket_mass") val rocketMass: String,
    @ColumnInfo(name = "rocket_diameter") val rocketDiameter: String,
    @ColumnInfo(name = "rocket_height") val rocketHeight: String,
    @ColumnInfo(name = "rocket_cost_per_launch") val rocketCostPerLaunch: String,
    @ColumnInfo(name = "rocket_first_flight") val rocketFirstFlight: String,
    @ColumnInfo(name = "rocket_description") val rocketDescription: String
    )