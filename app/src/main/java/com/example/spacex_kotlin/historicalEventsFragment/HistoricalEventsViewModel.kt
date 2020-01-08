package com.example.spacex_kotlin.historicalEventsFragment

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.spacex_kotlin.utils.LoadingState
import com.example.spacex_kotlin.repository.SpacexRepository
import com.example.spacex_kotlin.repository.model.room.events.HistoricalEvent
import com.example.spacex_kotlin.utils.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HistoricalEventsViewModel(context: Context, private val repo: SpacexRepository) : ViewModel() {

    private val _loadingState = MutableLiveData<LoadingState>()
    val loadingState: LiveData<LoadingState>
        get() = _loadingState


    val data: LiveData<List<HistoricalEvent>>
        get() = repo.getEventsFromDatabase()

    init {
        val sharedPrefValue = retriveSharedPreferencesFirstStartApp(context)
        if(context.isConnectedToNetwork() && sharedPrefValue){
            _loadingState.postValue(LoadingState.LOADING)
            GlobalScope.launch{
                withContext(Dispatchers.IO){
                    repo.populateDatabaseWithRetrofit()
                }
            }
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
    }

}
