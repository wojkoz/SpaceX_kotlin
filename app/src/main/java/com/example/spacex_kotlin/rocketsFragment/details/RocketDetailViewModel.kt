package com.example.spacex_kotlin.rocketsFragment.details


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.spacex_kotlin.LoadingState
import com.example.spacex_kotlin.repository.SpacexRepository
import com.example.spacex_kotlin.repository.model.retrofit.Rocket
import com.example.spacex_kotlin.repository.model.room.rocket.RocketDetail
import kotlinx.coroutines.*


class RocketDetailViewModel(private val id: String, private val repo: SpacexRepository) : ViewModel() {

    private val _loadingState = MutableLiveData<LoadingState>()
    val loadingState: LiveData<LoadingState>
        get() = _loadingState

    private var _data = MutableLiveData<Rocket>()
    val data: LiveData<RocketDetail> = repo.getRocketDetailFromDatabase(id)


    private val completableJob = Job()
    private val coroutineScope = CoroutineScope(Dispatchers.IO + completableJob)

    init {
        //fetchData()
    }

//    private fun fetchData(){
//        _loadingState.postValue(LoadingState.LOADING)
//
//        coroutineScope.launch {
//            try {
//                val webResponse = repo.getRocketDetailFromDatabase(id)
//                withContext(Dispatchers.Main){
//                    _data.value = webResponse
//                }
//
//            }catch (e: Throwable){
//                Log.e("RocketDetailViewModel","coroutines API Request", e)
//                _loadingState.postValue(LoadingState.error(e.message))
//            }
//
//        }
//        _loadingState.postValue(LoadingState.LOADED)
//    }

    override fun onCleared() {
        super.onCleared()
        completableJob.cancel()
    }
}
