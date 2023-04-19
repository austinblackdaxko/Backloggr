package com.ablack.backloggr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ablack.backloggr.ui.HomeScreen
import com.ablack.backloggr.ui.SearchScreen
import com.ablack.backloggr.ui.bottomnav.BottomNavigation
import com.ablack.backloggr.ui.homescreen.HomeScreen
import com.ablack.backloggr.ui.theme.BackloggrTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            BackloggrTheme {
                MyNavHost(navController = navController)
            }

        }
    }
}

@Composable
fun MyNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "Home") {
        composable(HomeScreen.route) {
            HomeScreen(onSearchClicked = {navController.navigate(SearchScreen.route)})

        }
        composable(SearchScreen.route) {
            SearchScreen("Austin", onHomeClicked = {navController.navigate(HomeScreen.route)})
        }
    }
}

@Composable
fun SearchScreen(name: String, onHomeClicked: () -> Unit) {
    Scaffold(bottomBar = {
        BottomNavigation(onHomeClicked = {onHomeClicked()})
    }) {
        Text(text = "Hello $name!")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BackloggrTheme {
        SearchScreen("Android", onHomeClicked = {})
    }
}