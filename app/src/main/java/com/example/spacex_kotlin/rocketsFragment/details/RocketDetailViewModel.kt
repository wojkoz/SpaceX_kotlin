package com.example.spacex_kotlin.rocketsFragment.details



import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacex_kotlin.repository.SpacexRepository
import com.example.spacex_kotlin.repository.model.room.rocket.RocketDetail
import kotlinx.coroutines.launch


class RocketDetailViewModel(private val id: String, private val repo: SpacexRepository) : ViewModel() {

    private val _data = MediatorLiveData<RocketDetail>()
    val data: LiveData<RocketDetail>
        get() = _data

    private fun getData() = viewModelScope.launch{
        _data.postValue(repo.getRocketDetailFromDatabase(id))
    }

    init {
        getData()
    }
}
