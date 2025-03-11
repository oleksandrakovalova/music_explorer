package com.okproject.musicexplorer.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.okproject.musicexplorer.domain.model.SimplifiedPlaylist
import com.okproject.musicexplorer.domain.search.SearchPlaylistsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SearchViewModel(
    private val searchPlaylistsUseCase: SearchPlaylistsUseCase
): ViewModel() {
    private val _queryFlow: MutableStateFlow<String> = MutableStateFlow("")
    val queryFlow: StateFlow<String> = _queryFlow.asStateFlow()

    private val _playlistsFlow: MutableStateFlow<List<SimplifiedPlaylist>> = MutableStateFlow(emptyList())
    val playlistsFlow: StateFlow<List<SimplifiedPlaylist>> = _playlistsFlow.asStateFlow()

    fun onQueryChanged(newQuery: String) {
        viewModelScope.launch {
            _queryFlow.emit(newQuery)
        }
    }

    fun search() {
        viewModelScope.launch {
            val result = searchPlaylistsUseCase(queryFlow.value)
            if (result.isSuccess) {
                _playlistsFlow.emit(result.getOrNull() ?: emptyList())
            }
        }
    }
}