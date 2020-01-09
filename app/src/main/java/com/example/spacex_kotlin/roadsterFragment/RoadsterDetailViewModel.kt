package com.example.spacex_kotlin.roadsterFragment

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.spacex_kotlin.repository.SpacexRepository
import com.example.spacex_kotlin.repository.model.room.roadster.Roadster
import com.example.spacex_kotlin.utils.openNewTabWindow

class RoadsterDetailViewModel(private val repo: SpacexRepository) : ViewModel() {
    val data: LiveData<Roadster>
        get() = repo.getRoadster()


    fun onOpenWikipediaLink(context: Context){
        openNewTabWindow(data.value!!.wikipediaLink, context)
    }
}
