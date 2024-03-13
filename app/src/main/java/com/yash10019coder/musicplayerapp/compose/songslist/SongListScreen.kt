package com.yash10019coder.musicplayerapp.compose.songslist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.yash10019coder.musicplayerapp.R

@Composable
fun SongList(songs: List<SongModel>, onSongClickListener: (id: Int) -> Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth(1.0f)
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        items(songs) { song ->
            SongItemView(
                imageUrl = song.imageUrl,
                songName = song.name,
                artistName = song.artist,
                onSongClick = { onSongClickListener(song.id) }
            )
        }
    }
}


@Preview
@Composable
fun PreviewSongList() {
    val songs = listOf(
        SongModel(
            id = 1,
            imageUrl = "https://picsum.photos/200/300",
            name = "Song Name",
            artist = "Artist Name"
        ),
        SongModel(
            id = 2,
            imageUrl = "https://picsum.photos/200/300",
            name = "Song Name",
            artist = "Artist Name"
        ),
        SongModel(
            id = 3,
            imageUrl = "https://picsum.photos/200/300",
            name = "Song Name",
            artist = "Artist Name"
        ),
        SongModel(
            id = 4,
            imageUrl = "https://picsum.photos/200/300",
            name = "Song Name",
            artist = "Artist Name"
        ),
        SongModel(
            id = 5,
            imageUrl = "https://picsum.photos/200/300",
            name = "Song Name",
            artist = "Artist Name"
        ),
        SongModel(
            id = 6,
            imageUrl = "https://picsum.photos/200/300",
            name = "Song Name",
            artist = "Artist Name"
        ),
        SongModel(
            id = 7,
            imageUrl = "https://picsum.photos/200/300",
            name = "Song Name",
            artist = "Artist Name"
        ),
        SongModel(
            id = 8,
            imageUrl = "https://picsum.photos/200/300",
            name = "Song Name",
            artist = "Artist Name"
        ),
        SongModel(
            id = 9,
            imageUrl = "https://picsum.photos/200/300",
            name = "Song Name",
            artist = "Artist Name"
        ),
        SongModel(
            id = 10,
            imageUrl = "https://picsum.photos/200/300",
            name = "Song Name",
            artist = "Artist Name"
        )
    )
    SongList(songs = songs, onSongClickListener = {})
}
