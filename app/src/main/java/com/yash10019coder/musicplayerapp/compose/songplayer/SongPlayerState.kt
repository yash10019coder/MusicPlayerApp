package com.yash10019coder.musicplayerapp.compose.songplayer

import androidx.compose.foundation.interaction.MutableInteractionSource
import com.yash10019coder.musicplayerapp.compose.songslist.SongModel

data class SongPlayerState(
    val selectedSong: SongModel,
    val isSongPlaying: Boolean,
    val isLoading: Boolean,
    val progress: Float,
)
