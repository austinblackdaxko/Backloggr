package com.ablack.backloggr.data.repositories

import com.ablack.backloggr.data.network.TVMazeAPI
import javax.inject.Inject

class TvShowRepository @Inject constructor(private val tvMazeAPI: TVMazeAPI) {
    fun searchShows(title: String) {
        // Todos: set up as suspended function
        // Call the tvmazeapi
        // Convert results to TvShow data class
        // Return the results
    }
}