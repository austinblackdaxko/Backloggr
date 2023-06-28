package com.ablack.backloggr.data.repositories

import com.ablack.backloggr.data.models.TVShow
import com.ablack.backloggr.data.network.BLResult
import com.ablack.backloggr.data.network.TVMazeAPI
import java.io.IOException

class TvShowRepositoryImpl(private val tvMazeAPI: TVMazeAPI) : TvShowRepository {

    override suspend fun searchShows(title: String) : BLResult<List<TVShow>> {
        try {
            val results = tvMazeAPI.searchShowsAPI(title)
            val tvShows = results.map {
                it.toTVShow()
            }.filter { !it.title.isNullOrBlank() }
            return BLResult.Success(tvShows)
        } catch (e:IOException) {
            return BLResult.Failure(e)
        }

    }
}
