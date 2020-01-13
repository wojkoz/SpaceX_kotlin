package com.example.spacex_kotlin.historicalEventsFragment.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacex_kotlin.repository.SpacexRepository
import com.example.spacex_kotlin.repository.model.room.events.HistoricalEvent
import kotlinx.coroutines.launch

class EventDetailViewModel( private val id: String, private val repo: SpacexRepository) : ViewModel() {

    private val _data = MediatorLiveData<HistoricalEvent>()
    val data: LiveData<HistoricalEvent> = _data


    private fun getDetail() = viewModelScope.launch {
            _data.postValue(repo.getEventDetailFromDatabase(id))
    }

    init {
        getDetail()
    }

}
