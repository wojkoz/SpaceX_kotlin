package com.example.spacex_kotlin.rocketsFragment.details


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.spacex_kotlin.utils.LoadingState
import com.example.spacex_kotlin.repository.SpacexRepository
import com.example.spacex_kotlin.repository.model.retrofit.Rocket
import com.example.spacex_kotlin.repository.model.room.rocket.RocketDetail


class RocketDetailViewModel(private val id: String, private val repo: SpacexRepository) : ViewModel() {

    private val _loadingState = MutableLiveData<LoadingState>()
    val loadingState: LiveData<LoadingState>
        get() = _loadingState

    private var _data = MutableLiveData<Rocket>()
    val data: LiveData<RocketDetail> = repo.getRocketDetailFromDatabase(id)


}
