package com.example.spacex_kotlin

import com.example.spacex_kotlin.repository.SpacexRepository
import com.example.spacex_kotlin.repository.model.retrofit.SpacexApi
import com.example.spacex_kotlin.repository.SpacexRepositoryImpl
import com.example.spacex_kotlin.repository.model.room.SpacexDatabase
import com.example.spacex_kotlin.rocketsFragment.RocketsViewModel
import com.example.spacex_kotlin.rocketsFragment.details.RocketDetailViewModel
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val viewModelModule = module{
    viewModel{
        RocketsViewModel(get())
    }
    viewModel { (id: String) -> RocketDetailViewModel(id, get()) }
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