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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.yash10019coder.musicplayerapp.ui.compose.common.ProgressBar
import com.yash10019coder.musicplayerapp.ui.compose.common.ProgressLoader
import timber.log.Timber

@Composable
fun SongList(
    navController: NavController,
    viewModel: SongsListViewModel
) {
    val state by viewModel.state.collectAsState()

    if (state.isLoading) {
        ProgressBar()
    } else {
        SongList(songs = state.songs, onSongClickListener = { songId ->
            viewModel.selectSong(songId)
            navController.navigate("songPlayer/$songId")
            Timber.i("Song selected: $songId")
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
                .fillMaxWidth(1.0f),
        ) {
            items(songs) { song ->
                SongItemView(
                    imageUrl = "https://cms.samespace.com/assets/${song.imageUrl}",
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
    val songs = mutableListOf<SongModel>()
    for (i in 1..30) {
        songs.add(
            SongModel(
                id = i,
                name = "Song $i",
                artist = "Artist $i",
                imageUrl = "https://cms.samespace.com/assets/artist$i.jpg",
                songUrl = "https://cms.samespace.com/assets/song$i.mp3",
                isTopTrack = false
            )
        )
    }
    SongList(songs = songs, onSongClickListener = {})
}
