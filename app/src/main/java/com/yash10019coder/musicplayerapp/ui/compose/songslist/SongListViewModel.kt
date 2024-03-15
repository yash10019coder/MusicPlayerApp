package com.yash10019coder.musicplayerapp.ui.compose.songslist


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yash10019coder.domain.mediaplayer.MediaPlayerController
import com.yash10019coder.domain.repository.SongsRepo
import com.yash10019coder.musicplayerapp.ui.compose.mappers.SongMapper.SongsDtoListToUImodelList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SongsListViewModel @Inject constructor(
    private val songsRepo: SongsRepo,
    private val mediaPlayerController: MediaPlayerController
) : ViewModel() {
    private val _state =
        MutableStateFlow(SongsListState(emptyList(), null, isSongPlaying = false, isLoading = true))
    val state: StateFlow<SongsListState> = _state.asStateFlow()

    init {
        loadSongs()
    }

    private fun loadSongs() {
        viewModelScope.launch {
            val songs = songsRepo.getSongs().SongsDtoListToUImodelList()
            _state.value = SongsListState(songs, null, isSongPlaying = false, isLoading = false)
        }
    }

    fun selectSong(songId: Int) {
        _state.value = _state.value.copy(selectedSongID = songId)
        mediaPlayerController.playNewSong(_state.value.songs[songId].songUrl)
    }

    fun playPauseSong() {
        if (_state.value.isSongPlaying) {
            mediaPlayerController.pausePlayback()
        } else {
            mediaPlayerController.startPlayback()
        }
        _state.value = _state.value.copy(isSongPlaying = !_state.value.isSongPlaying)
    }

    fun playNextSong(){
        val currentSongId = _state.value.selectedSongID ?: 0
        val nextSongId = (currentSongId + 1) % _state.value.songs.size
        selectSong(nextSongId)
    }

    fun playPrevSong(){
        val currentSongId = _state.value.selectedSongID ?: 0
        val prevSongId = (currentSongId - 1) % _state.value.songs.size
        selectSong(prevSongId)
    }
}

