package com.example.spacex_kotlin.launchesFragment.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.spacex_kotlin.repository.SpacexRepository
import com.example.spacex_kotlin.repository.model.room.launch.Launch

class LaunchDetailViewModel(private val id: String, private val repo: SpacexRepository) : ViewModel() {
   val data: LiveData<Launch>
        get() = repo.getLaunchDetailFromDatabase(id)
}
