package com.example.spacex_kotlin.launchesFragment.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacex_kotlin.repository.SpacexRepository
import com.example.spacex_kotlin.repository.model.room.launch.Launch
import kotlinx.coroutines.launch

class LaunchDetailViewModel(private val id: String, private val repo: SpacexRepository) : ViewModel() {
    private val _data = MediatorLiveData<Launch>()
    val data: LiveData<Launch>
        get() = _data

    private fun getData() = viewModelScope.launch {
        _data.postValue(repo.getLaunchDetailFromDatabase(id))
    }
    init {
        getData()
    }

}
