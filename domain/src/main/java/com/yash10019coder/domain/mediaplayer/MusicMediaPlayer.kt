package com.yash10019coder.domain.mediaplayer

import android.media.AudioAttributes
import android.media.MediaPlayer
import java.io.IOException
import javax.inject.Inject

class MyMediaPlayer @Inject constructor() {
    private var mediaPlayer: MediaPlayer? = null
    fun initMediaPlayer(url: String) {
        mediaPlayer = MediaPlayer().apply {
            setAudioAttributes(
                AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .build()
            )
            setDataSource(url)
            prepare()
            start()
        }
    }

    fun start() {
        mediaPlayer?.start()
    }

    fun pause() {
        mediaPlayer?.pause()
    }

    fun stop() {
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
    }

    fun isPlaying(): Boolean {
        return mediaPlayer?.isPlaying ?: false
    }

    fun seekTo(position: Int) {
        mediaPlayer?.seekTo(position)
    }

    fun getCurrentPosition(): Int {
        return mediaPlayer?.currentPosition ?: 0
    }

    fun getDuration(): Int {
        return mediaPlayer?.duration ?: 0
    }

    fun setOnCompletionListener(listener: MediaPlayer.OnCompletionListener) {
        mediaPlayer?.setOnCompletionListener(listener)
    }

    fun setOnErrorListener(listener: MediaPlayer.OnErrorListener) {
        mediaPlayer?.setOnErrorListener(listener)
    }

    fun setProgressListener(listener: MediaPlayer.OnBufferingUpdateListener) {
        mediaPlayer?.setOnBufferingUpdateListener(listener)
    }

    fun release() {
        mediaPlayer?.release()
    }
}
