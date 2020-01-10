package com.example.spacex_kotlin.historicalEventsFragment.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.spacex_kotlin.repository.SpacexRepository
import com.example.spacex_kotlin.repository.model.room.events.HistoricalEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class EventDetailViewModel( id: String, private val repo: SpacexRepository) : ViewModel() {

    val data: LiveData<HistoricalEvent> = repo.getEventDetailFromDatabase(id)

    fun onRefresh(){
        GlobalScope.launch {
            withContext(Dispatchers.IO){
                repo.populateDatabaseWithEvents()
            }

        }
    }
}
