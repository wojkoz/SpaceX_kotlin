package com.example.spacex_kotlin

import com.example.spacex_kotlin.repository.SpacexApi
import com.example.spacex_kotlin.repository.SpacexRepository
import com.example.spacex_kotlin.rocketsFragment.RocketsViewModel
import com.example.spacex_kotlin.rocketsFragment.details.RocketDetailViewModel
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val viewModelModule = module{
    viewModel{
        RocketsViewModel(get())
    }
}

val repositoryModule = module {
    single {
        SpacexRepository(get())
    }
}

val apiModule = module {
    fun provideUseApi(retrofit: Retrofit): SpacexApi {
        return retrofit.create(SpacexApi::class.java)
    }

    single { provideUseApi(get()) }
}

val retrofitModule = module {


    fun provideHttpClient(): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder()

        return okHttpClientBuilder.build()
    }

    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.spacexdata.com/v3/")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
    }

    single { provideHttpClient() }
    single { provideRetrofit(get()) }
}