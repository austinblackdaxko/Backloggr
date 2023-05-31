package com.ablack.backloggr.data.network.responses

data class TVShowResponse(val id: String, val url: String, val name: String, val image: TVImage?)

data class TVImage(val medium: String, val original : String)
