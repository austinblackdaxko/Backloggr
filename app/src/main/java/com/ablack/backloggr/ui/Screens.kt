package com.ablack.backloggr.ui

interface Screen {
    val route: String
}

object HomeScreen : Screen {
    override val route: String = "Home"
}

object SearchScreen : Screen {
    override val route: String = "Search"
}