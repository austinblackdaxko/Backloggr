package com.ablack.backloggr.di

import com.ablack.backloggr.data.network.MovieAPI
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
    fun movieAPI(retrofit: Retrofit) = retrofit.create(MovieAPI::class.java)

}