package com.yash10019coder.domain.repository

import com.yash10019coder.data.models.backends.SongModel
import com.yash10019coder.data.models.backends.SongsService
import com.yash10019coder.domain.dto.SongsModelDto
import com.yash10019coder.domain.mappers.SongsMapper.SongsModelListToSongsDtoList
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class SongsRepoImpl @Inject constructor(
    private val songsService: SongsService,
    private val coroutineDispatcher: CoroutineDispatcher
) : SongsRepo {
    override suspend fun getSongs(): List<SongsModelDto> {
        return withContext(coroutineDispatcher) {
            return@withContext try {
                val songs = songsService.getSongs().SongsModelListToSongsDtoList()
                songs.ifEmpty {
                    throw Exception("No songs found")
                }
            } catch (e: Exception) {
                throw Exception("No songs found")
            }
        }
    }
}
