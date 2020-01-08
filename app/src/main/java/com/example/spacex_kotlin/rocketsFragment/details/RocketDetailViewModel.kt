package com.example.spacex_kotlin.rocketsFragment.details


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.spacex_kotlin.utils.LoadingState
import com.example.spacex_kotlin.repository.SpacexRepository
import com.example.spacex_kotlin.repository.model.retrofit.Rocket
import com.example.spacex_kotlin.repository.model.room.rocket.RocketDetail


class RocketDetailViewModel(id: String, repo: SpacexRepository) : ViewModel() {

    val data: LiveData<RocketDetail> = repo.getRocketDetailFromDatabase(id)

}
