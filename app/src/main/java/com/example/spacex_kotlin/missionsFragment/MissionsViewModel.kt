package com.example.spacex_kotlin.missionsFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.spacex_kotlin.repository.SpacexRepository
import com.example.spacex_kotlin.repository.model.room.mission.Mission

class MissionsViewModel(private val repo: SpacexRepository) : ViewModel() {

    val data: LiveData<List<Mission>>
        get() = repo.getMissionsFromDatabase()
}
