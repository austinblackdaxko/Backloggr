package com.ablack.backloggr.ui.homescreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ablack.backloggr.R
import com.ablack.backloggr.data.VideoGame
import com.ablack.backloggr.data.network.MovieAPI
import com.ablack.backloggr.data.network.models.TVShow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val movieAPI: MovieAPI) : ViewModel() {

    val tvShows = mutableStateListOf<TVShow>()

    val title : String = "hello world"
    val videoGame = VideoGame("Hollow Knight", "Metroidvania", "A great video" +
            "game", R.drawable.hollowknight )
    val vgtitle : String = videoGame.title

    val videoGames = listOf(videoGame, videoGame, videoGame, videoGame, videoGame, videoGame,
        videoGame, videoGame, videoGame, videoGame,videoGame,videoGame,videoGame,videoGame,videoGame,
        videoGame,videoGame,videoGame,videoGame)

    fun fetchTVShows() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = movieAPI.getFullSchedule()
            tvShows.clear()
            tvShows.addAll(result)
        }
    }

}