package com.example.spacex_kotlin.rocketsFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.spacex_kotlin.utils.LoadingState
import com.example.spacex_kotlin.repository.SpacexRepository
import com.example.spacex_kotlin.repository.model.room.rocket.Rocket

class RocketsViewModel(private val repo: SpacexRepository) : ViewModel() {


    val data: LiveData<List<Rocket>>
        get() = repo.getRocketsFromDatabase()!!


}
