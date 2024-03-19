package com.yash10019coder.musicplayerapp.ui.compose.songplayer

import com.yash10019coder.musicplayerapp.ui.compose.songslist.SongModel

/**
 * Represents the UI state for the SongPlayerScreen.
 *
 * @param selectedSong The currently selected song to play. Can be null if no song is selected.
 * @param isPlaying Indicates if a song is currently playing.
 * @param isLoading Indicates if the song data is loading. Useful for showing a loading indicator.
 * @param progress The current playback progress of the song as a percentage (0f to 100f).
 * @param currentPosition The current playback position in milliseconds. Useful for updating the seek bar.
 * @param duration The duration of the current song in milliseconds. Useful for setting the seek bar's max value.
 * @param error An optional error message if something goes wrong (e.g., song fails to load).
 */
data class SongPlayerState(
    val selectedSong: SongModel?,
    val isPlaying: Boolean = false,
    val isLoading: Boolean = true,
    var progress: Float = 0f,
    var currentPosition: Long = 0L,
    var duration: Long = 0L,
    val error: String? = null
)
