package com.example.spacex_kotlin.roadsterFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacex_kotlin.repository.SpacexRepository
import com.example.spacex_kotlin.repository.model.room.roadster.Roadster
import kotlinx.coroutines.launch

class RoadsterDetailViewModel(private val repo: SpacexRepository) : ViewModel() {

    private val _data = MediatorLiveData<Roadster>()
    val data: LiveData<Roadster>
        get() = _data

    private fun getData() = viewModelScope.launch {
        _data.postValue(repo.getRoadster())
    }

    init {
        getData()
    }


}
