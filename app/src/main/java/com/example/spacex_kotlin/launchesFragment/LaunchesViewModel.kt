package com.example.spacex_kotlin.launchesFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.spacex_kotlin.repository.SpacexRepository
import com.example.spacex_kotlin.repository.model.room.launch.Launch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LaunchesViewModel(private val repo: SpacexRepository) : ViewModel() {
    val data: LiveData<List<Launch>>
        get() = repo.getLaunchesFromDatabase()

    fun onRefresh(){
        GlobalScope.launch {
            withContext(Dispatchers.IO){
                repo.populateDatabaseWithLaunches()
            }

        }
    }
}
