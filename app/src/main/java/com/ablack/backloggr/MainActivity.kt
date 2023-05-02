package com.ablack.backloggr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ablack.backloggr.ui.HomeScreen
import com.ablack.backloggr.ui.SearchScreen
import com.ablack.backloggr.ui.homescreen.HomeScreen
import com.ablack.backloggr.ui.searchscreen.SearchScreen
import com.ablack.backloggr.ui.searchscreen.SearchViewModel
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
            SearchScreen(SearchViewModel(), onHomeClicked = {navController.navigate(HomeScreen.route)})
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BackloggrTheme {
        SearchScreen(SearchViewModel(), onHomeClicked = {})
    }
}