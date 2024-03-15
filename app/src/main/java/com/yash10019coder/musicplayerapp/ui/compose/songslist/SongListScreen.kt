package com.yash10019coder.musicplayerapp.ui.compose.songslist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.yash10019coder.musicplayerapp.ui.compose.common.ProgressLoader

@Composable
fun SongList(
    viewModel: SongsListViewModel = viewModel()
) {
    val state by viewModel.state.collectAsState()

    if (state.isLoading) {
        ProgressLoader(isLoading = state.isLoading)
    } else {
        SongList(songs = state.songs, onSongClickListener = { songId ->
            viewModel.selectSong(songId)
            // Additional actions when a song is clicked, e.g., navigate to player screen
        })
    }
}

@Composable
fun SongList(songs: List<SongModel>, onSongClickListener: (id: Int) -> Unit) {
    Surface(
        modifier = Modifier
            .fillMaxWidth(1.0f)
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth(1.0f)
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
}


@Preview
@Composable
fun PreviewSongList() {
    val songs = listOf<SongModel>()
    SongList(songs = songs, onSongClickListener = {})
}
