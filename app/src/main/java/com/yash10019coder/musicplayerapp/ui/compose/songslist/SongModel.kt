package com.yash10019coder.musicplayerapp.compose.songslist

import androidx.compose.ui.graphics.painter.Painter

data class SongModel(
    val id: Int,
    val imageUrl: String,
    val name: String,
    val artist: String
)
