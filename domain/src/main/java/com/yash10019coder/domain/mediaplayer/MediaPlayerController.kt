package com.yash10019coder.domain.mediaplayer

import android.content.Context
import android.media.MediaPlayer
import javax.inject.Inject

class MediaPlayerController @Inject constructor(
    private val mediaPlayer: MyMediaPlayer
) {
    fun initMediaPlayer(url: String) {
        mediaPlayer.initMediaPlayer(url)
    }

    fun startPlayback() {
        mediaPlayer.start()
    }

    fun pausePlayback() {
        mediaPlayer.pause()
    }

    fun stopPlayback() {
        mediaPlayer.stop()
    }

    fun isPlaying(): Boolean {
        return mediaPlayer.isPlaying()
    }

    fun seekTo(position: Int) {
        mediaPlayer.seekTo(position)
    }

    fun getCurrentPosition(): Int {
        return mediaPlayer.getCurrentPosition()
    }

    fun getDuration(): Int {
        return mediaPlayer.getDuration()
    }

    fun setOnCompletionListener(listener: MediaPlayer.OnCompletionListener) {
        mediaPlayer.setOnCompletionListener(listener)
    }

    fun setOnErrorListener(listener: MediaPlayer.OnErrorListener) {
        mediaPlayer.setOnErrorListener(listener)
    }

    fun playNewSong(url: String) {
        mediaPlayer.stop()
        mediaPlayer.initMediaPlayer(url)
        mediaPlayer.start()
    }
}
