package com.example.spacex_kotlin.rocketsFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.spacex_kotlin.LoadingState
import com.example.spacex_kotlin.repository.SpacexRepository
import com.example.spacex_kotlin.repository.model.room.rocket.Rocket
import kotlinx.coroutines.*

class RocketsViewModel(private val repo: SpacexRepository) : ViewModel() {

    private val _loadingState = MutableLiveData<LoadingState>()
    val loadingState: LiveData<LoadingState>
        get() = _loadingState

    private var _data = MutableLiveData<List<Rocket>>()
    val data: LiveData<List<Rocket>>
        get() = repo.getRocketsFromDatabase()!!

    private val completableJob = Job()
    private val coroutineScope = CoroutineScope(Dispatchers.IO + completableJob)



    override fun onCleared() {
        super.onCleared()
        completableJob.cancel()
    }
}
