package com.example.spacex_kotlin.missionsFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.spacex_kotlin.repository.SpacexRepository
import com.example.spacex_kotlin.repository.model.room.mission.Mission
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MissionsViewModel(private val repo: SpacexRepository) : ViewModel() {

    val data: LiveData<List<Mission>>
        get() = repo.getMissionsFromDatabase()

    fun onRefresh(){
        GlobalScope.launch {
            withContext(Dispatchers.IO){
                repo.populateDatabaseWithMissions()
            }

        }
    }
}
