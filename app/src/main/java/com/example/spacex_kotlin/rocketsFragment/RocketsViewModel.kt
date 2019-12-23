package com.example.spacex_kotlin.rocketsFragment

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.spacex_kotlin.LoadingState
import com.example.spacex_kotlin.repository.SpacexApi
import com.example.spacex_kotlin.repository.SpacexRepository
import com.example.spacex_kotlin.repository.WebAccess
import com.example.spacex_kotlin.repository.model.Rocket
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RocketsViewModel(private val repo: SpacexRepository) : ViewModel() {

    private val _loadingState = MutableLiveData<LoadingState>()
    val loadingState: LiveData<LoadingState>
        get() = _loadingState

    private var _data = MutableLiveData<List<Rocket>>()
    val data: LiveData<List<Rocket>>
        get() = _data

    init {
        loadPartsAndUpdateList()
    }


    private fun loadPartsAndUpdateList() {
        // Launch Kotlin Coroutine on Android's main thread
        GlobalScope.launch(Dispatchers.Main) {
            // Execute web request through coroutine call adapter & retrofit
            val webResponse = WebAccess.rocketsApi.getRockets().await()

            if (webResponse.isSuccessful) {

                val rocketList : List<Rocket>? = webResponse.body()
                Log.d("RocketsViewModel", rocketList?.toString())

                _data.value = rocketList


            } else {
                // Print error information to the console
                Log.d("RocketsViewModel", "Error ${webResponse.code()}")
            }
        }
    }

//    private val _loadingState = MutableLiveData<LoadingState>()
//    val loadingState: LiveData<LoadingState>
//        get() = _loadingState
//
//    private val _data = MutableLiveData<List<Rocket>>()
//    val data: LiveData<List<Rocket>>
//        get() = _data
//
//    init {
//        fetchData()
//    }
//
//    private fun fetchData() {
//        _loadingState.postValue(LoadingState.LOADING)
//        repo.getRockets().enqueue(this)
//    }
//
//    override fun onFailure(call: Call<List<Rocket>>, t: Throwable) {
//        _loadingState.postValue(LoadingState.error(t.message))
//    }
//
//    override fun onResponse(call: Call<List<Rocket>>, response: Response<List<Rocket>>) {
//        if (response.isSuccessful) {
//            _data.postValue(response.body())
//            _loadingState.postValue(LoadingState.LOADED)
//        } else {
//            _loadingState.postValue(LoadingState.error(response.errorBody().toString()))
//        }
//    }
}
