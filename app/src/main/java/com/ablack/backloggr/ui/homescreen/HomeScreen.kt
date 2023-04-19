package com.ablack.backloggr.ui.homescreen


import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ablack.backloggr.R
import com.ablack.backloggr.data.network.models.TVShow


@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {

    LaunchedEffect(viewModel) {
        viewModel.fetchTVShows()
    }

    Scaffold(bottomBar = {
        Row(modifier = Modifier.fillMaxWidth().background(Color.Magenta).padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly) {
            Text(text = "Home", fontSize = 20.sp)
            Text(text = "Search", fontSize = 20.sp)
        }
    }) {
        LazyColumn(modifier = Modifier.padding(bottom = it.calculateBottomPadding())) {
            items(viewModel.tvShows) {
                    item ->  GameItem(tvShow = item)
            }
        }
    }
}

@Composable
fun GameItem(tvShow: TVShow) {
    Row() {
        val image: Painter = painterResource(id = R.drawable.hollowknight)
        Image(
            painter = image,
            contentDescription = "${tvShow.name} cover",
            contentScale = ContentScale.Crop,            // crop the image if it's not a square
            modifier = Modifier
                .size(45.dp)
                .clip(CircleShape)                      // clip to the circle shape
        )

        Text(
            text = tvShow.name,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(15.dp)
        )
        Text(
            text = tvShow.id,
            fontSize = 12.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
                .offset(x = 30.dp)
        )
    }
}