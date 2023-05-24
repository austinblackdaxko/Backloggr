package com.ablack.backloggr.data.network

import com.ablack.backloggr.data.network.models.TVShow
import retrofit2.http.GET
import retrofit2.http.Query

interface TVMazeAPI {

    //https://api.tvmaze.com/schedule/full

    @GET("schedule/full")
    suspend fun getFullSchedule() : List<TVShow>

    @GET("search/shows")
    suspend fun searchShows(@Query("q") showName : String) : List<TVShow>
    // figure out return type and create models

}