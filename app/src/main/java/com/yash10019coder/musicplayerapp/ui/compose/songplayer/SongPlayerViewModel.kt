package com.yash10019coder.musicplayerapp.ui.compose.songplayer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yash10019coder.musicplayerapp.ui.compose.songslist.SongModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class SongPlayerViewModel : ViewModel() {
    private val _state = MutableStateFlow(
        SongPlayerState(
            selectedSong = null,
            isPlaying = false,
            isLoading = true,
            progress = 0f
        )
    )
    val state: StateFlow<SongPlayerState> = _state.asStateFlow()

    // Example function to simulate loading a song
    fun loadSong(song: SongModel) {
        viewModelScope.launch {
            _state.value = SongPlayerState(
                selectedSong = song,
                isPlaying = false,
                isLoading = false,
                progress = 0f
            )
            // Simulate song loading process...
        }
    }

    // Toggle play/pause
    fun togglePlayPause() {
        viewModelScope.launch {
            val currentState = _state.value
            _state.value = currentState.copy(isPlaying = !currentState.isPlaying)
            // Here, integrate with your actual playback logic to play or pause the song
        }
    }

    // Update song progress
    fun updateProgress(progress: Float) {
        viewModelScope.launch {
            val currentState = _state.value
            _state.value = currentState.copy(progress = progress)
            // Update the current playback position of your music player
        }
    }

    fun playNextSong() {

    }

    fun playPreviousSong() {

    }
}
