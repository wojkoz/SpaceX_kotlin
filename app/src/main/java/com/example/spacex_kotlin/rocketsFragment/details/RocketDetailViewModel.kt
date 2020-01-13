package com.example.spacex_kotlin.rocketsFragment.details


import androidx.lifecycle.*
import com.example.spacex_kotlin.utils.LoadingState
import com.example.spacex_kotlin.repository.SpacexRepository
import com.example.spacex_kotlin.repository.model.retrofit.Rocket
import com.example.spacex_kotlin.repository.model.room.rocket.RocketDetail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class RocketDetailViewModel(private val id: String, private val repo: SpacexRepository) : ViewModel() {

    val _data = MediatorLiveData<RocketDetail>()
    val data: LiveData<RocketDetail>
        get() = _data

    private fun getData() = viewModelScope.launch{
        _data.postValue(repo.getRocketDetailFromDatabase(id))
    }

    init {
        getData()
    }

}
