package com.example.spacex_kotlin.roadsterFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.spacex_kotlin.repository.SpacexRepository
import com.example.spacex_kotlin.repository.model.room.roadster.Roadster
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RoadsterDetailViewModel(private val repo: SpacexRepository) : ViewModel() {
    val data: LiveData<Roadster>
        get() = repo.getRoadster()

    fun onRefresh(){
        GlobalScope.launch {
            withContext(Dispatchers.IO){
                repo.populateDatabaseWithRoadster()
            }

        }
    }

}
