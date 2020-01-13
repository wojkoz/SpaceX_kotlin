package com.example.spacex_kotlin.rocketsFragment

import androidx.lifecycle.*
import com.example.spacex_kotlin.utils.LoadingState
import com.example.spacex_kotlin.repository.SpacexRepository
import com.example.spacex_kotlin.repository.model.room.rocket.Rocket
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RocketsViewModel(private val repo: SpacexRepository) : ViewModel() {

    private val _data = MediatorLiveData<List<Rocket>>()
    val data: LiveData<List<Rocket>>
        get() = _data

    private fun getData() = viewModelScope.launch {
        _data.postValue(repo.getRocketsFromDatabase())
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
