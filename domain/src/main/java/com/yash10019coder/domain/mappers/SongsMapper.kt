package com.yash10019coder.domain.mappers

import com.yash10019coder.data.models.backends.SongModel
import com.yash10019coder.domain.dto.SongsModelDto
import javax.inject.Inject

object SongsMapper {
    fun SongModel.SongsModelToDto(songsModel: SongModel): SongsModelDto {
        return SongsModelDto(
            id = songsModel.id,
            name = songsModel.name,
            artist = songsModel.artist,
            coverImageUrl = songsModel.cover,
            imageUrl = songsModel.cover,
            isTopTrack = songsModel.topTrack,
            songUrl = songsModel.url
        )
    }

    fun List<SongModel>.SongsModelListToSongsDtoList(): List<SongsModelDto> {
        return this.map { songModel -> songModel.SongsModelToDto(songModel) }
    }
}
