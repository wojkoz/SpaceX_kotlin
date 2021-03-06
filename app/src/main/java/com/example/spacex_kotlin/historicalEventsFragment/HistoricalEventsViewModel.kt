package com.example.spacex_kotlin.historicalEventsFragment

import android.content.Context
import android.util.Log
import androidx.lifecycle.*
import com.example.spacex_kotlin.repository.SpacexRepository
import com.example.spacex_kotlin.repository.model.room.events.HistoricalEvent
import com.example.spacex_kotlin.utils.*
import kotlinx.coroutines.launch


class HistoricalEventsViewModel(private val context: Context ,private val repo: SpacexRepository) : ViewModel() {

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
        getData()
    }

    init {
        val sharedPrefValue = retriveSharedPreferencesFirstStartApp(context)
        if(context.isConnectedToNetwork() && sharedPrefValue){
            _loadingState.postValue(LoadingState.LOADING)

            getDataFromRetrofit()

            saveSharedPreferencesFirstStartApp(context)

            _loadingState.postValue(LoadingState.LOADED)

        }
        else{
            if(!sharedPrefValue){
                Log.d("AppFirstStart", "FALSE")
                getData()
            }

            else{
                _loadingState.postValue(LoadingState.error("No network access!"))
            }

        }


    }

    fun onRefresh(){
        _loadingState.postValue(LoadingState.LOADING)
        if(context.isConnectedToNetwork()){
            getDataFromRetrofit()
            getData()
            _loadingState.postValue(LoadingState.LOADED)
        }else{
            _loadingState.postValue(LoadingState.error(NO_INTERNET_CONNECTION))
        }
    }

}
