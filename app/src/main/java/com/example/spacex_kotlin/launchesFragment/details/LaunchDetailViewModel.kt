package com.example.spacex_kotlin.launchesFragment.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.spacex_kotlin.repository.SpacexRepository
import com.example.spacex_kotlin.repository.model.room.launch.Launch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LaunchDetailViewModel(private val id: String, private val repo: SpacexRepository) : ViewModel() {
   val data: LiveData<Launch>
        get() = repo.getLaunchDetailFromDatabase(id)

    fun onRefresh(){
        GlobalScope.launch {
            withContext(Dispatchers.IO){
                repo.populateDatabaseWithLaunches()
            }

        }
    }
}
