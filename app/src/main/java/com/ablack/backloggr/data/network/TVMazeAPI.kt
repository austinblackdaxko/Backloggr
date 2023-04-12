package com.ablack.backloggr.data.network

import com.ablack.backloggr.data.network.models.TVShow
import retrofit2.http.GET

interface TVMazeAPI {

    //https://api.tvmaze.com/schedule/full

    @GET("schedule/full")
    suspend fun getFullSchedule() : List<TVShow>

}