package com.ablack.backloggr.ui.homescreen

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ablack.backloggr.data.network.TVMazeAPI
import com.ablack.backloggr.data.network.models.TVShow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val tvMazeAPI: TVMazeAPI) : ViewModel() {

    val tvShows = mutableStateListOf<TVShow>()



    fun fetchTVShows() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = tvMazeAPI.getFullSchedule()
            tvShows.clear()
            tvShows.addAll(result.take(50))
        }
    }
}