package com.ablack.backloggr.data.repositories

import com.ablack.backloggr.data.models.TVShow
import com.ablack.backloggr.data.network.BLResult
import com.ablack.backloggr.data.network.TVMazeAPI
import com.ablack.backloggr.data.network.responses.SearchResultResponse
import com.ablack.backloggr.data.network.responses.Show
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.IOException


internal class TvShowRepositoryImplTest {
    private val tvMazeAPI = TVMazeAPITD()
    private lateinit var SUT: TvShowRepositoryImpl

    @BeforeEach
    fun setup() {
        SUT = TvShowRepositoryImpl(tvMazeAPI)
    }

    @Test
    fun `searchShows TV Shows with null titles are filtered out`() = runTest {
// Test TV Shows w/ null titles are filtered out
//        Given
        tvMazeAPI.addShow("the wire")
        tvMazeAPI.addShow(null)
        tvMazeAPI.addShow(null)

//        When
        val result = SUT.searchShows("the wire")

//        Then
        result.shouldBeInstanceOf<BLResult.Success<List<TVShow>>>()
        result.data.size.shouldBe(1)
    }

    // TV Shows w/ blank titles are filtered out

    @Test
    fun `searchShows TV Shows with blank titles are filtered out`() = runTest {
        // Given
        tvMazeAPI.addShow("breaking bad")
        tvMazeAPI.addShow("the sopranos")
        tvMazeAPI.addShow("")
        tvMazeAPI.addShow("      ")

        // When
        val result = SUT.searchShows("asdf")

        // Then
        result.shouldBeInstanceOf<BLResult.Success<List<TVShow>>>()
        result.data.size.shouldBe(2)
    }

    // Successful API call returns tv shows

    // Return an error if the API call fails
    @Test
    fun `searchShows return error if API call fails`() = runTest {
        // Given
        tvMazeAPI.forceError()
        // When
        val result = SUT.searchShows("asdf")

        // Then
        result.shouldBeInstanceOf<BLResult.Failure<Any>>()

    }


}


internal class TVMazeAPITD : TVMazeAPI {

    private val responses = mutableListOf<SearchResultResponse>()
    private var throwError = false
    override suspend fun searchShowsAPI(showName: String): List<SearchResultResponse> {
        if(throwError) throw IOException()
        return responses
    }

    fun addShow(title: String?) {
        val show = Show(name = title)
        val searchResultResponse = SearchResultResponse(show = show)
        responses.add(searchResultResponse)
    }

    fun forceError() {
        throwError = true
    }
}