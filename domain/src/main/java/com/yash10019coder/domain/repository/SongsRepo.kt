package com.yash10019coder.domain.repository

import com.yash10019coder.data.models.backends.SongModel
import com.yash10019coder.domain.dto.SongsModelDto

interface SongsRepo {
    suspend fun getSongs(): List<SongsModelDto>
}
