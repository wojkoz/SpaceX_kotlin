package com.example.spacex_kotlin.missionsFragment.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.spacex_kotlin.repository.SpacexRepository
import com.example.spacex_kotlin.repository.model.room.mission.Mission
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MissionDetailViewModel(private val id: String, private val repo: SpacexRepository) : ViewModel() {
    val data: LiveData<Mission>
        get() = repo.getMissionDetailFromDatabase(id)

    fun onRefresh(){
        GlobalScope.launch {
            withContext(Dispatchers.IO){
                repo.populateDatabaseWithMissions()
            }

        }
    }
}
