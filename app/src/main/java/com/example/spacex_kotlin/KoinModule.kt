package com.example.spacex_kotlin

import android.util.Log
import com.example.spacex_kotlin.historicalEventsFragment.HistoricalEventsViewModel
import com.example.spacex_kotlin.historicalEventsFragment.details.EventDetailViewModel
import com.example.spacex_kotlin.launchesFragment.LaunchesViewModel
import com.example.spacex_kotlin.launchesFragment.details.LaunchDetailViewModel
import com.example.spacex_kotlin.missionsFragment.MissionsViewModel
import com.example.spacex_kotlin.missionsFragment.details.MissionDetailViewModel
import com.example.spacex_kotlin.repository.SpacexRepository
import com.example.spacex_kotlin.repository.model.retrofit.SpacexApi
import com.example.spacex_kotlin.repository.SpacexRepositoryImpl
import com.example.spacex_kotlin.repository.model.retrofit.Roadster
import com.example.spacex_kotlin.repository.model.room.SpacexDatabase
import com.example.spacex_kotlin.roadsterFragment.RoadsterDetailViewModel
import com.example.spacex_kotlin.rocketsFragment.RocketsViewModel
import com.example.spacex_kotlin.rocketsFragment.details.RocketDetailViewModel
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val viewModelModule = module{
    //main viewModels
    viewModel{
        RocketsViewModel(get(), get())
    }
    viewModel {
        HistoricalEventsViewModel(get(), get())
    }
    viewModel {
        MissionsViewModel(get(), get())
    }
    viewModel {
        LaunchesViewModel(get(), get())
    }


    //detail viewModels
    viewModel { (id: String) -> RocketDetailViewModel(id, get()) }

    viewModel { (id: String) -> EventDetailViewModel(id, get()) }
    viewModel {
        RoadsterDetailViewModel(get())
    }
    viewModel { (id: String) -> MissionDetailViewModel(id, get()) }
    viewModel { (id: String) -> LaunchDetailViewModel(id, get()) }
}

val repositoryModule = module {
    single<SpacexRepository> {
        SpacexRepositoryImpl(get(), get())
    }
}


val retrofitModule = module {


    fun provideSpacexApi() : SpacexApi {


        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.spacexdata.com/v3/")
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()

        // Create Retrofit client
        return retrofit.create(SpacexApi::class.java)
    }

    single { provideSpacexApi() }

}

val roomModule = module{
    single { SpacexDatabase.getDatabase(get()) }
}