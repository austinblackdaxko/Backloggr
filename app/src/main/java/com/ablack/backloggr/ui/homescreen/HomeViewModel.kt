package com.ablack.backloggr.ui.homescreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModel
import com.ablack.backloggr.R
import com.ablack.backloggr.data.VideoGame
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    val title : String = "hello world"
    val videoGame = VideoGame("Hollow Knight", "Metroidvania", "A great video" +
            "game", R.drawable.hollowknight )
    val vgtitle : String = videoGame.title

}