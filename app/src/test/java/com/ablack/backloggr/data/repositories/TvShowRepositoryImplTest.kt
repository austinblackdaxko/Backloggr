package com.ablack.backloggr.data.repositories

import com.ablack.backloggr.data.network.TVMazeAPI
import com.ablack.backloggr.data.network.responses.SearchResultResponse
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test


internal class TvShowRepositoryImplTest {
    private val tvMazeAPI = TVMazeAPITD()
    private lateinit var SUT : TvShowRepositoryImpl

    @BeforeEach
    fun setup() {
        SUT = TvShowRepositoryImpl(tvMazeAPI)
    }

    @Test
    fun `searchShows returns list of tv shows when successful`()=runTest {
//        Given

//        When
//        val result = SUT.searchShows("the wire")
//        Then
    }
}

internal class TVMazeAPITD : TVMazeAPI {
    override suspend fun searchShowsAPI(showName: String): List<SearchResultResponse> {
        TODO("Not yet implemented")
    }
}