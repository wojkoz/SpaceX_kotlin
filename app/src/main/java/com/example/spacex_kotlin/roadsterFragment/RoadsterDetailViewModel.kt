package com.example.spacex_kotlin.roadsterFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.spacex_kotlin.repository.SpacexRepository
import com.example.spacex_kotlin.repository.model.room.roadster.Roadster

class RoadsterDetailViewModel(private val repo: SpacexRepository) : ViewModel() {
    val data: LiveData<Roadster>
        get() = repo.getRoadster()
}
