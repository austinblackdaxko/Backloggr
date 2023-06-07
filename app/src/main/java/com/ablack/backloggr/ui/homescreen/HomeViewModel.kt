package com.ablack.backloggr.ui.homescreen

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ablack.backloggr.data.network.responses.TVShowResponse
import com.ablack.backloggr.data.repositories.TvShowRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val tvShowRepository: TvShowRepository) : ViewModel() {

    val tvShows = mutableStateListOf<TVShowResponse>()



    fun fetchTVShows() {
        viewModelScope.launch(Dispatchers.IO) {
            val searchShows = tvShowRepository.searchShows("breaking bad")
//            val result = tvMazeAPI.getFullSchedule()
//            tvShows.clear()
//            tvShows.addAll(result.take(50))
            Log.d("!!!!", "$searchShows")
        }
    }
}