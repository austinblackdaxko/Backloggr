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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ablack.backloggr.R
import com.ablack.backloggr.data.network.responses.TVShowResponse
import com.ablack.backloggr.ui.HomeScreen
import com.ablack.backloggr.ui.bottomnav.BottomNavigation


@Composable
fun HomeScreen(onSearchClicked: () -> Unit, viewModel: HomeViewModel = hiltViewModel()) {

    LaunchedEffect(viewModel) {
        viewModel.fetchTVShows()
    }

    Scaffold(bottomBar = {

        BottomNavigation(selectedScreen = HomeScreen, onSearchClicked = {onSearchClicked()})

    }) {
        LazyColumn(modifier = Modifier.padding(bottom = it.calculateBottomPadding())) {
            items(viewModel.tvShows) { item ->
                GameItem(tvShow = item)
            }
        }
    }
}



@Composable
fun GameItem(tvShow: TVShowResponse) {
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