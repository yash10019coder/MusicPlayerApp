package com.yash10019coder.domain.mediaplayer

import android.media.AudioAttributes
import android.media.MediaPlayer
import java.io.IOException
import javax.inject.Inject

class MyMediaPlayer @Inject constructor(
    private var mediaPlayer: MediaPlayer?
){
    fun initMediaPlayer(url: String) {
        mediaPlayer?.apply {
            setAudioAttributes(
                AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .build()
            )

            setDataSource(url)
            prepareAsync()

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
}
