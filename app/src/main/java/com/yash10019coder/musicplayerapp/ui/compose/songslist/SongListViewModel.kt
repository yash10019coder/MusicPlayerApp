package com.yash10019coder.musicplayerapp.ui.compose.songslist


import android.media.MediaPlayer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yash10019coder.domain.mediaplayer.MediaPlayerController
import com.yash10019coder.domain.repository.SongsRepo
import com.yash10019coder.musicplayerapp.ui.compose.mappers.SongMapper.SongsDtoListToUImodelList
import com.yash10019coder.musicplayerapp.ui.compose.songplayer.SongPlayerState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SongsListViewModel @Inject constructor(
    private val songsRepo: SongsRepo,
    private val mediaPlayerController: MediaPlayerController
) : ViewModel() {
    private val _state =
        MutableStateFlow(SongsListState(emptyList(), null, isSongPlaying = false, isLoading = true))
    val state: StateFlow<SongsListState> = _state.asStateFlow()

    private val _statePlayer = MutableStateFlow(
        SongPlayerState(
            selectedSong = null,
            isPlaying = false,
            isLoading = true,
            progress = 0f
        )
    )
    val statePlayer: StateFlow<SongPlayerState> = _statePlayer.asStateFlow()

    init {
        loadSongs()
        mediaPlayerController.setOnErrorListener { mp, what, extra ->
            Timber.e("Error playing song")
            Timber.e("Error: $what, Extra: $extra")

            _state.value = _state.value.copy(isSongPlaying = false)
            true
        }

        mediaPlayerController.setOnCompletionListener { mp ->
            _statePlayer.value.duration = mp.duration.toLong()
            _statePlayer.value.currentPosition = mp.currentPosition.toLong()
            _statePlayer.value.progress =
                (mp.currentPosition.toFloat() / mp.duration.toFloat()) * 100
            Timber.d("Song completed")
        }
    }

    private fun loadSongs() {
        _state.value = _state.value.copy(isLoading = true)
        viewModelScope.launch {
            val songs = songsRepo.getSongs().SongsDtoListToUImodelList()
            _state.value = SongsListState(songs, null, isSongPlaying = false, isLoading = false)
        }
    }

    fun selectSong(songId: Int) {
        _state.value = _state.value.copy(selectedSongID = songId)
        viewModelScope.launch {
            _state.value = _state.value.copy(isSongPlaying = true)
            mediaPlayerController.initMediaPlayer(_state.value.songs[songId].songUrl)
            mediaPlayerController.startPlayback()
        }
    }

    fun playPauseSong() {
        if (_state.value.isSongPlaying) {
            viewModelScope.launch {
                mediaPlayerController.pausePlayback()
                _state.value = _state.value.copy(isSongPlaying = !_state.value.isSongPlaying)
            }
        } else {
            viewModelScope.launch {
                mediaPlayerController.startPlayback()
                _state.value = _state.value.copy(isSongPlaying = !_state.value.isSongPlaying)
            }
        }
    }

    fun playNextSong() {
        val currentSongId = _state.value.selectedSongID ?: 0
        val nextSongId = (currentSongId + 1) % _state.value.songs.size
        viewModelScope.launch {
            mediaPlayerController.stopPlayback()
            selectSong(nextSongId)
        }
    }

    fun playPrevSong() {
        val currentSongId = _state.value.selectedSongID ?: 0
        val prevSongId = (currentSongId - 1) % _state.value.songs.size
        viewModelScope.launch {
            mediaPlayerController.stopPlayback()
            selectSong(prevSongId)
        }
    }

    fun loadSongPlayer(songId: Int) {
        viewModelScope.launch {
            _statePlayer.value = SongPlayerState(
                selectedSong = _state.value.songs[songId],
                isPlaying = true,
                isLoading = false,
                progress = 0f
            )
            // Simulate song loading process...
        }
    }

    // Toggle play/pause
    fun togglePlayPausePlayer() {
        viewModelScope.launch {
            val currentState = _statePlayer.value
            _statePlayer.value = currentState.copy(isPlaying = !currentState.isPlaying)
            // Here, integrate with your actual playback logic to play or pause the song
        }
    }

    // Update song progress
    fun updateProgressPlayer(progress: Float) {
        viewModelScope.launch {
            val currentState = _statePlayer.value
            _statePlayer.value = currentState.copy(progress = progress)
            // Update the current playback position of your music player
        }
    }


    fun playPreviousSongPlayer() {

    }

    fun selectSongPlayer(songModel: SongModel) {

    }

    fun updateSongPlayerState(songPlayerState: SongPlayerState) {
        _statePlayer.value = songPlayerState
    }
}

