package com.example.spacex_kotlin.historicalEventsFragment

import android.content.Context
import android.util.Log
import androidx.lifecycle.*
import com.example.spacex_kotlin.utils.LoadingState
import com.example.spacex_kotlin.repository.SpacexRepository
import com.example.spacex_kotlin.repository.model.room.events.HistoricalEvent
import com.example.spacex_kotlin.utils.isConnectedToNetwork
import com.example.spacex_kotlin.utils.retriveSharedPreferencesFirstStartApp
import com.example.spacex_kotlin.utils.saveSharedPreferencesFirstStartApp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HistoricalEventsViewModel(context: Context ,private val repo: SpacexRepository) : ViewModel() {

    private val _loadingState = MutableLiveData<LoadingState>()
    val loadingState: LiveData<LoadingState>
        get() = _loadingState

    private val _data = MediatorLiveData<List<HistoricalEvent>>()
    val data: LiveData<List<HistoricalEvent>>
        get() = _data

    private fun getData() = viewModelScope.launch{
        _data.postValue(repo.getEventsFromDatabase())
    }

    private fun getDataFromRetrofit() = viewModelScope.launch {
        repo.populateDatabaseWithRetrofit()
    }

    init {
        val sharedPrefValue = retriveSharedPreferencesFirstStartApp(context)
        if(context.isConnectedToNetwork() && sharedPrefValue){
            _loadingState.postValue(LoadingState.LOADING)

            getDataFromRetrofit()
            _loadingState.postValue(LoadingState.LOADED)

            saveSharedPreferencesFirstStartApp(context)

        }
        else{
            if(!sharedPrefValue){
                Log.d("AppFirstStart", "FALSE")
            }

            else{
                _loadingState.postValue(LoadingState.error("No network access!"))
            }

        }

        getData()
    }

    fun onRefresh(){
        getDataFromRetrofit()
        getData()
    }
}
