package com.example.spacex_kotlin.rocketsFragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.spacex_kotlin.LoadingState
import com.example.spacex_kotlin.repository.SpacexRepository
import com.example.spacex_kotlin.repository.model.Rocket
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RocketsViewModel(private val repo: SpacexRepository) : ViewModel() {

    private val _loadingState = MutableLiveData<LoadingState>()
    val loadingState: LiveData<LoadingState>
        get() = _loadingState

    private var _data = MutableLiveData<List<Rocket>>()
    val data: LiveData<List<Rocket>>
        get() = _data

    init {
        fetchData()
    }

    private fun fetchData(){
        _loadingState.postValue(LoadingState.LOADING)
        //add if/else when there is no internet connection(load from ROOM)
        loadRocketList()
    }

    private fun loadRocketList() {
        // Launch Kotlin Coroutine on Android's main thread
        GlobalScope.launch(Dispatchers.Main) {
            // Execute web request through coroutine call adapter & retrofit
            val webResponse = repo.getAllRocketsAsync().await()

            if (webResponse.isSuccessful) {

                val rocketList : List<Rocket>? = webResponse.body()
                Log.d("RocketsViewModel", "Rocket List")

                _data.value = rocketList
                _loadingState.postValue(LoadingState.LOADED)

            } else {
                _loadingState.postValue(LoadingState.error(webResponse.message()))
                // Print error information to the console
                Log.d("RocketsViewModel", "Error ${webResponse.code()}")
            }
        }
    }

}
