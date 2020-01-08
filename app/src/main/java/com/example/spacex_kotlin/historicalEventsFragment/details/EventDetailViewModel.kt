package com.example.spacex_kotlin.historicalEventsFragment.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.spacex_kotlin.utils.LoadingState
import com.example.spacex_kotlin.repository.SpacexRepository
import com.example.spacex_kotlin.repository.model.room.events.HistoricalEvent

class EventDetailViewModel( private val id: String, private val repo: SpacexRepository) : ViewModel() {

    private val _loadingState = MutableLiveData<LoadingState>()
    val loadingState: LiveData<LoadingState>
        get() = _loadingState

    val data: LiveData<HistoricalEvent> = repo.getEventDetailFromDatabase(id)
}
