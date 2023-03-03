package com.ablack.backloggr.data

import androidx.annotation.DrawableRes

data class VideoGame(
    val title: String,
    val genre: String,
    val description: String,
    @DrawableRes val coverImage: Int,
)