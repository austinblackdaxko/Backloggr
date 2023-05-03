package com.ablack.backloggr.ui.bottomnav

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ablack.backloggr.ui.HomeScreen
import com.ablack.backloggr.ui.Screen
import com.ablack.backloggr.ui.SearchScreen

@Composable
fun BottomNavigation(selectedScreen: Screen, onSearchClicked: () -> Unit = {}, onHomeClicked: () -> Unit = {}) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Magenta)
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            modifier = Modifier.clickable { onHomeClicked() },
            text = "Home",
            fontSize = 20.sp,
            fontWeight = if(selectedScreen is HomeScreen) FontWeight.Bold else FontWeight.Normal
        )
        Text(
            modifier = Modifier.clickable { onSearchClicked() },
            text = "Search",
            fontSize = 20.sp,
            fontWeight = if(selectedScreen is SearchScreen) FontWeight.Bold else FontWeight.Normal
        )
    }
}