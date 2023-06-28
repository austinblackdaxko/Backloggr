package com.ablack.backloggr.data.repositories

import com.ablack.backloggr.data.models.TVShow
import com.ablack.backloggr.data.network.BLResult


interface TvShowRepository {
    /**
     * Fetches list of TV Shows based on title provided
     *
     * @param title title of the show user is searching for
     * @return returns list of [TVShow] or an empty list if no results found
     */
    suspend fun searchShows(title: String) : BLResult<List<TVShow>>


}


