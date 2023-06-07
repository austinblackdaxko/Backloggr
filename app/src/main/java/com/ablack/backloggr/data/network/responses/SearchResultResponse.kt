package com.ablack.backloggr.data.network.responses

import com.ablack.backloggr.data.models.TVShow

data class SearchResultResponse(
    val score: Any? = null,
    val show: Show? = null
) {
    fun toTVShow(): TVShow {
        return TVShow(
            title = show?.name,
            imageUrl = show?.image?.original,
            genres = show?.genres ?: emptyList()
        )
    }
}

data class Network(
    val country: Country? = null,
    val name: String? = null,
    val id: Int? = null,
    val officialSite: Any? = null
)

data class Show(
    val summary: String? = null,
    val image: Image? = null,
    val averageRuntime: Int? = null,
    val dvdCountry: Any? = null,
    val links: Links? = null,
    val premiered: String? = null,
    val rating: Rating? = null,
    val runtime: Int? = null,
    val weight: Int? = null,
    val language: String? = null,
    val type: String? = null,
    val url: String? = null,
    val officialSite: String? = null,
    val network: Network? = null,
    val schedule: Schedule? = null,
    val webChannel: Any? = null,
    val genres: List<String>? = null,
    val name: String? = null,
    val ended: String? = null,
    val id: Int? = null,
    val externals: Externals? = null,
    val updated: Int? = null,
    val status: String? = null
)

data class Schedule(
    val days: List<String?>? = null,
    val time: String? = null
)

data class Image(
    val original: String? = null,
    val medium: String? = null
)

data class Self(
    val href: String? = null
)

data class Previousepisode(
    val href: String? = null
)

data class Country(
    val code: String? = null,
    val timezone: String? = null,
    val name: String? = null
)

data class Links(
    val self: Self? = null,
    val previousepisode: Previousepisode? = null
)

data class Externals(
    val thetvdb: Int? = null,
    val imdb: String? = null,
    val tvrage: Int? = null
)

//data class WebChannel(
//    val country: Country? = null,
//    val name: String? = null,
//    val id: Int? = null,
//    val officialSite: String? = null
//)

data class Rating(
    val average: Any? = null
)

