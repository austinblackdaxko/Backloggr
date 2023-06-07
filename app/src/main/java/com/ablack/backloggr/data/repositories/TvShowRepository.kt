package com.ablack.backloggr.data.repositories

import com.ablack.backloggr.data.models.TVShow
import com.ablack.backloggr.data.network.TVMazeAPI
import javax.inject.Inject

class TvShowRepository @Inject constructor(private val tvMazeAPI: TVMazeAPI) {
    suspend fun searchShows(title: String) : List<TVShow> {
        val results = tvMazeAPI.searchShowsAPI(title)
        val tvShows = results.map {
            it.toTVShow()
        }.filter { !it.title.isNullOrBlank() }
        return tvShows
        // Todos: set up as suspended function
        // Call the tvmazeapi
        // Convert results to TvShow data class
        // Return the results
    }
}

