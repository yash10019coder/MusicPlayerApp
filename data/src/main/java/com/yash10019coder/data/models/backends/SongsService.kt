package com.yash10019coder.data.models.backends

import retrofit2.http.GET

interface SongsService {
    @GET("/items/songs")
    suspend fun getSongs(): List<SongModel>
}
