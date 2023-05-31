package com.ablack.backloggr.data.network

import com.ablack.backloggr.data.network.responses.TVShowResponse
import com.ablack.backloggr.data.network.responses.SearchResultResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TVMazeAPI {

    //https://api.tvmaze.com/schedule/full

    @GET("schedule/full")
    suspend fun getFullSchedule() : List<TVShowResponse>

    @GET("search/shows")
    suspend fun searchShows(@Query("q") showName : String) : List<SearchResultResponse>
    // figure out return type and create models

}