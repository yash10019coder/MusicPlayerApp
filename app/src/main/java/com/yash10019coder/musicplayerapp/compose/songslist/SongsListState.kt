package com.yash10019coder.musicplayerapp.compose.songslist

data class SongsListState(
    val songs: List<SongModel>,
    val selectedSongID: Int?,
    val isSongPlaying: Boolean,
    val isLoading: Boolean
)
