package com.example.spacex_kotlin.missionsFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacex_kotlin.repository.SpacexRepository
import com.example.spacex_kotlin.repository.model.room.mission.Mission
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MissionsViewModel(private val repo: SpacexRepository) : ViewModel() {

    private val _data = MediatorLiveData<List<Mission>>()
    val data: LiveData<List<Mission>>
        get() = _data

    private fun getData() = viewModelScope.launch {
        _data.postValue(repo.getMissionsFromDatabase())
    }
    private fun getDataFromRetrofit() = viewModelScope.launch {
        repo.populateDatabaseWithRetrofit()
    }

    init {
        getData()
    }

    fun onRefresh(){
        getDataFromRetrofit()
        getData()
    }
}
