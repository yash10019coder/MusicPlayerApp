package com.yash10019coder.domain.mediaplayer

import android.content.Context
import android.media.MediaPlayer
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MediaPlayerController @Inject constructor(
    private val mediaPlayer: MyMediaPlayer,
) {
    private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO
    suspend fun initMediaPlayer(url: String) {
        withContext(coroutineDispatcher) {
            mediaPlayer.initMediaPlayer(url)
        }
    }

    suspend fun startPlayback() {
        withContext(coroutineDispatcher) {
            mediaPlayer.start()
        }
    }

    suspend fun pausePlayback() {
        withContext(coroutineDispatcher) {
            mediaPlayer.pause()
        }
    }

    suspend fun stopPlayback() {
        withContext(coroutineDispatcher) {
            mediaPlayer.stop()
        }
    }

    suspend fun release(){
        withContext(coroutineDispatcher) {
            mediaPlayer.release()
        }
    }

    suspend fun isPlaying(): Boolean {
        return withContext(coroutineDispatcher) {
            mediaPlayer.isPlaying()
        }
    }

    suspend fun seekTo(position: Int) {
        withContext(coroutineDispatcher) {
            mediaPlayer.seekTo(position)
        }
    }

    suspend fun getCurrentPosition(): Int {
        return withContext(coroutineDispatcher) {
            mediaPlayer.getCurrentPosition()
        }
    }

    suspend fun getDuration(): Int {
        return withContext(coroutineDispatcher) {
            mediaPlayer.getDuration()
        }
    }

    fun setOnCompletionListener(listener: MediaPlayer.OnCompletionListener) {
        mediaPlayer.setOnCompletionListener(listener)
    }

    fun setOnErrorListener(listener: MediaPlayer.OnErrorListener) {
        mediaPlayer.setOnErrorListener(listener)
    }

    suspend fun playNewSong(url: String) {
        stopPlayback()
        initMediaPlayer(url)
    }

    fun setOnBufferingUpdateListener(listener: MediaPlayer.OnBufferingUpdateListener) {
        mediaPlayer.setProgressListener(listener)
    }
}
