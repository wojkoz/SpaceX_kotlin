package com.example.spacex_kotlin.rocketsFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.spacex_kotlin.LoadingState
import com.example.spacex_kotlin.repository.SpacexRepository
import com.example.spacex_kotlin.repository.model.room.Rocket
import kotlinx.coroutines.*

class RocketsViewModel(private val repo: SpacexRepository) : ViewModel() {

    private val _loadingState = MutableLiveData<LoadingState>()
    val loadingState: LiveData<LoadingState>
        get() = _loadingState

   // private var _data = MutableLiveData<List<Rocket>>()
  //  val data: LiveData<List<Rocket>>
     //   get() = _data

    private val completableJob = Job()
    //private val coroutineScope = CoroutineScope(Dispatchers.IO + completableJob)


    val rockets : LiveData<List<Rocket>>? = repo.getRocketsFromDatabase()

    init {
        //use only at first app start or once in week
        //coroutineScope.launch { repo.insertToDatabase() }


        //fetchData()
    }


//    private fun fetchData(){
//        _loadingState.postValue(LoadingState.LOADING)
//
//        coroutineScope.launch {
//            try{
//
//                val rocketList = repo.getRocketsFromDatabase()
//                withContext(Dispatchers.Main){
//
//                    _data.value = rocketList as List<Rocket>
//                }
//            }catch (e: Throwable){
//                Log.e("RocketsViewModel", e.message)
//            }
//        }
//        _loadingState.postValue(LoadingState.LOADED)
//    }


    override fun onCleared() {
        super.onCleared()
        completableJob.cancel()
    }
}
