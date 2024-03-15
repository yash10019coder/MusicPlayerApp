package com.yash10019coder.musicplayerapp.ui.compose.songslist

import androidx.compose.ui.graphics.painter.Painter

data class SongModel(
    val id: Int,
    val imageUrl: String,
    val name: String,
    val artist: String,
    val songUrl: String,
    val isTopTrack: Boolean
)
