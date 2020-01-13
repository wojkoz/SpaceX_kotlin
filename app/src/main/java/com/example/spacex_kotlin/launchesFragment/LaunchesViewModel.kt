package com.example.spacex_kotlin.launchesFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacex_kotlin.repository.SpacexRepository
import com.example.spacex_kotlin.repository.model.room.launch.Launch
import kotlinx.coroutines.launch

class LaunchesViewModel(private val repo: SpacexRepository) : ViewModel() {
    private val _data = MediatorLiveData<List<Launch>>()
    val data: LiveData<List<Launch>>
        get() = _data

    private fun getData() = viewModelScope.launch {
        _data.postValue(repo.getLaunchesFromDatabase())
    }
    private fun getDataFromRetrofit() = viewModelScope.launch {
        repo.populateDatabaseWithRetrofit()
    }
    init{
        getData()
    }

    fun onRefresh(){
        getDataFromRetrofit()
        getData()
    }
}
