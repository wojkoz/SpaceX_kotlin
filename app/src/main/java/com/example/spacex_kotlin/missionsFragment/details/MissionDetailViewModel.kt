package com.example.spacex_kotlin.missionsFragment.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacex_kotlin.repository.SpacexRepository
import com.example.spacex_kotlin.repository.model.room.mission.Mission
import kotlinx.coroutines.launch

class MissionDetailViewModel(private val id: String, private val repo: SpacexRepository) : ViewModel() {

    private val _data = MediatorLiveData<Mission>()
    val data: LiveData<Mission>
        get() = _data

    private fun getData() = viewModelScope.launch {
        _data.postValue(repo.getMissionDetailFromDatabase(id))
    }
    init {
        getData()
    }

}
