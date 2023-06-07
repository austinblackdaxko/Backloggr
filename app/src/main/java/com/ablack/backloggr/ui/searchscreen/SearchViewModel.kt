package com.ablack.backloggr.ui.searchscreen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ablack.backloggr.data.models.TVShow
import com.ablack.backloggr.data.repositories.TvShowRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val tvShowRepository: TvShowRepository) : ViewModel() {

    val tvShows = mutableStateListOf<TVShow>()

    private val _searchWidgetState: MutableState<SearchWidgetState> =
        mutableStateOf(value = SearchWidgetState.CLOSED)

    val searchWidgetState: State<SearchWidgetState> = _searchWidgetState

    private val _searchTextState: MutableState<String> =
        mutableStateOf(value = "")
    val searchTextState: State<String> = _searchTextState

    fun updateSearchWidgetState(newValue: SearchWidgetState) {
        _searchWidgetState.value = newValue
    }

    fun updateSearchTextState(newValue: String) {
        _searchTextState.value = newValue

        viewModelScope.launch(Dispatchers.IO) {
            val result = tvShowRepository.searchShows(newValue)
            tvShows.clear()
            tvShows.addAll(result.take(50))

        }
        // launch tvmaze api in coroutine  viewmodel scope
    }
}