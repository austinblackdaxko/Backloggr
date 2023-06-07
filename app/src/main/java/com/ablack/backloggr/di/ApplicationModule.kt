package com.ablack.backloggr.di

import com.ablack.backloggr.data.network.TVMazeAPI
import com.ablack.backloggr.data.repositories.TvShowRepository
import com.ablack.backloggr.data.repositories.TvShowRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module // collection of things that can be injected
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Provides
    fun retroFit() : Retrofit =
        Retrofit.Builder()
            .baseUrl("https://api.tvmaze.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    @Provides
    fun tvMazeAPI(retrofit: Retrofit) = retrofit.create(TVMazeAPI::class.java)

    @Provides
    fun tvShowRepository(tvMazeAPI: TVMazeAPI) : TvShowRepository = TvShowRepositoryImpl(tvMazeAPI)

}