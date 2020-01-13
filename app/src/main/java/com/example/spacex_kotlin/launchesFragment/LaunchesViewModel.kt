package com.example.spacex_kotlin.launchesFragment

import android.content.Context
import androidx.lifecycle.*
import com.example.spacex_kotlin.repository.SpacexRepository
import com.example.spacex_kotlin.repository.model.room.launch.Launch
import com.example.spacex_kotlin.utils.LoadingState
import com.example.spacex_kotlin.utils.NO_INTERNET_CONNECTION
import com.example.spacex_kotlin.utils.isConnectedToNetwork
import kotlinx.coroutines.launch

class LaunchesViewModel(private val repo: SpacexRepository, private val context: Context) : ViewModel() {

    private val _data = MediatorLiveData<List<Launch>>()
    val data: LiveData<List<Launch>>
        get() = _data

    private val _loadingState = MutableLiveData<LoadingState>()
    val loadingState: LiveData<LoadingState>
        get() = _loadingState

    private fun getData() = viewModelScope.launch {
        _data.postValue(repo.getLaunchesFromDatabase())
    }
    private fun getDataFromRetrofit() = viewModelScope.launch {
        repo.populateDatabaseWithRetrofit()
    }
    init{
        getData()
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
