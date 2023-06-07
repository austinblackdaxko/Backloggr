package com.ablack.backloggr.data.repositories

import com.ablack.backloggr.data.models.TVShow
import com.ablack.backloggr.data.network.TVMazeAPI

class TvShowRepositoryImpl(private val tvMazeAPI: TVMazeAPI) : TvShowRepository {
    override suspend fun searchShows(title: String) : List<TVShow> {
        val results = tvMazeAPI.searchShowsAPI(title)
        val tvShows = results.map {
            it.toTVShow()
        }.filter { !it.title.isNullOrBlank() }
        return tvShows
    }
}
