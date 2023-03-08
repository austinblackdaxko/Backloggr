package com.ablack.backloggr.ui.homescreen

import android.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
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

@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {
//    Text(text = viewModel.title)
    val scrollState = rememberScrollState()
    Row(modifier = Modifier.verticalScroll(scrollState)) {

        val image: Painter = painterResource(id = R.drawable.hollowknight)
        Image(
            painter = image,
            contentDescription = "gamecover",
            contentScale = ContentScale.Crop,            // crop the image if it's not a square
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)                       // clip to the circle shape
        )

        Text(
            text = viewModel.videoGame.title,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth()
        )
    }
}