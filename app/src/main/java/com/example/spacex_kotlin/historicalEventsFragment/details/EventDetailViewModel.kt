package com.example.spacex_kotlin.historicalEventsFragment.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.spacex_kotlin.utils.LoadingState
import com.example.spacex_kotlin.repository.SpacexRepository
import com.example.spacex_kotlin.repository.model.room.events.HistoricalEvent

class EventDetailViewModel( id: String, repo: SpacexRepository) : ViewModel() {

    val data: LiveData<HistoricalEvent> = repo.getEventDetailFromDatabase(id)
}
