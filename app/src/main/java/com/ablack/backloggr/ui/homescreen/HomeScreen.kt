package com.ablack.backloggr.ui.homescreen

import android.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ablack.backloggr.R
import com.ablack.backloggr.data.VideoGame




@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {

    viewModel.fetchTVShows()
//    Text(text = viewModel.title)
    val scrollState = rememberScrollState()
//    GameItem(videoGame = viewModel.videoGame)

    LazyColumn() {
        items(viewModel.videoGames) {
            item ->  GameItem(videoGame = item)
        }
    }

}

@Composable
fun GameItem(videoGame: VideoGame) {
    Row() {
        val image: Painter = painterResource(id = R.drawable.hollowknight)
        Image(
            painter = image,
            contentDescription = "${videoGame.title} game cover",
            contentScale = ContentScale.Crop,            // crop the image if it's not a square
            modifier = Modifier
                .size(45.dp)
                .clip(CircleShape)                      // clip to the circle shape
        )

        Text(
            text = videoGame.title,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(15.dp)
        )
        Text(
            text = videoGame.genre,
            fontSize = 12.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
                .offset(x = 30.dp)
        )
    }
}