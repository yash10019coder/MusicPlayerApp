package com.yash10019coder.domain.dto

data class SongsModelDto(
    val id: Int,
    val imageUrl: String,
    val name: String,
    val artist: String,
    val coverImageUrl: String,
    val isTopTrack: Boolean,
    val songUrl: String
)
