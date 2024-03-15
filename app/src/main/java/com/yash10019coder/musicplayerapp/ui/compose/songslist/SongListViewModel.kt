package com.yash10019coder.musicplayerapp.ui.compose.songslist


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class SongsListViewModel : ViewModel() {
    private val _state =
        MutableStateFlow(SongsListState(emptyList(), null, isSongPlaying = false, isLoading = true))
    val state: StateFlow<SongsListState> = _state.asStateFlow()

    init {
        loadSongs() // Initial load
    }

    private fun loadSongs() {
        viewModelScope.launch {
            // Simulate loading songs from a repository
            val songs = listOf(
                // Assume this list is fetched from your data source
                SongModel(
                    id = 1,
                    imageUrl = "https://picsum.photos/200/300",
                    name = "Song Name 1",
                    artist = "Artist Name 1"
                ),
                // Add more SongModel instances
            )
            _state.value = SongsListState(songs, null, isSongPlaying = false, isLoading = false)
        }
    }

    fun selectSong(songId: Int) {
        _state.value = _state.value.copy(selectedSongID = songId)
        // Optionally, manage play/pause state here as well
    }

    // Additional functions to manage play/pause and song selection
}

