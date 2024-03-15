package com.yash10019coder.musicplayerapp.ui.compose.mappers

import com.yash10019coder.domain.dto.SongsModelDto
import com.yash10019coder.musicplayerapp.ui.compose.songslist.SongModel

object SongMapper {
    fun SongsModelDto.SongDtoToUImodel(): SongModel {
        return SongModel(
            id = this.id,
            imageUrl = this.coverImageUrl,
            name = this.name,
            artist = this.artist,
            songUrl = this.songUrl,
            isTopTrack = this.isTopTrack
        )
    }

    fun List<SongsModelDto>.SongsDtoListToUImodelList(): List<SongModel> {
        return this.map { songDto -> songDto.SongDtoToUImodel() }
    }
}
