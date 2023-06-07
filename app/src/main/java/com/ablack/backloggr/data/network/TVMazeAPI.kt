package com.ablack.backloggr.data.network

import com.ablack.backloggr.data.network.responses.SearchResultResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TVMazeAPI {

    //https://api.tvmaze.com/schedule/full


    @GET("search/shows")
    suspend fun searchShowsAPI(@Query("q") showName : String) : List<SearchResultResponse>
    // figure out return type and create models

}