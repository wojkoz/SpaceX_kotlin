package com.example.spacex_kotlin.rocketsFragment.details


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.spacex_kotlin.utils.LoadingState
import com.example.spacex_kotlin.repository.SpacexRepository
import com.example.spacex_kotlin.repository.model.retrofit.Rocket
import com.example.spacex_kotlin.repository.model.room.rocket.RocketDetail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class RocketDetailViewModel(id: String, private val repo: SpacexRepository) : ViewModel() {

    val data: LiveData<RocketDetail> = repo.getRocketDetailFromDatabase(id)

    fun onRefresh(){
        GlobalScope.launch {
            withContext(Dispatchers.IO){
                repo.populateDatabaseWithRockets()
            }

        }
    }

}
