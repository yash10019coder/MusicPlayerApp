package com.yash10019coder.musicplayerapp.ui.compose.songplayer

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.yash10019coder.musicplayerapp.R
import com.yash10019coder.musicplayerapp.ui.compose.songslist.SongModel
import com.yash10019coder.musicplayerapp.ui.compose.songslist.SongsListViewModel

//TODO: issue #11


@Composable
fun SongPlayerScreen(
    viewModel: SongsListViewModel,
) {
    val state by viewModel.statePlayer.collectAsState()
    val song = state.selectedSong!!
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            AsyncImage(
                model = "https://cms.samespace.com/assets/${song.imageUrl}",
                contentDescription = "Song Image",
                modifier = Modifier
                    .aspectRatio(1.0f)
                    .padding(0.dp, 50.dp, 0.dp, 0.dp)
                    .clip(shape = RoundedCornerShape(3.dp)),
            )


            SongDetails(
                name = song.name,
                artist = song.artist,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )


            SliderSeekBar(
                songUIState = SongPlayerState(
                    selectedSong = song,
                    isPlaying = false,
                    isLoading = false,
                    progress = 0.5f
                ),
                onSongPlayerState = { songPlayerState ->
                    viewModel.updateSongPlayerState(songPlayerState)
                },
                modifier = Modifier
            )


            SongControls(
                onPreviousSongClick = { viewModel.playPreviousSongPlayer() },
                onPlayPauseClick = { viewModel.togglePlayPausePlayer() },
                onNextSongClick = { viewModel.playNextSongPlayer() },
                modifier = Modifier
                    .fillMaxWidth(1.0f)
                    .padding(16.dp, 0.dp, 16.dp, 100.dp)
            )
        }
    }
}

@Composable
fun Divider(modifier: Modifier) {
    androidx.compose.material3.Divider(
        modifier = modifier,
        thickness = 3.dp,
        color = androidx.compose.ui.graphics.Color.Gray
    )
}

@Composable
fun SongDetails(name: String, artist: String, modifier: Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = name,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Text(
            text = artist,
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun SliderSeekBar(
    songUIState: SongPlayerState,
    onSongPlayerState: (SongPlayerState) -> Unit,
    modifier: Modifier
) {
    Slider(
        value = songUIState.progress,
        onValueChange = {
            onSongPlayerState(songUIState.copy(progress = it))
        },
        colors = SliderDefaults.colors(
            thumbColor = MaterialTheme.colorScheme.secondary,
            activeTrackColor = MaterialTheme.colorScheme.onPrimary,
            inactiveTrackColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.1f)

        ),
        modifier = modifier
    )
}

@Composable
fun SongControls(
    onPreviousSongClick: () -> Unit,
    onPlayPauseClick: () -> Unit,
    onNextSongClick: () -> Unit,
    modifier: Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_previous),
            contentDescription = "Previous",
            modifier = Modifier
                .clickable { onPreviousSongClick() }
        )


        Image(painter = painterResource(id = R.drawable.ic_play_pause),
            contentDescription = "Play/Pause",
            modifier = Modifier
                .clickable { onPlayPauseClick() }
        )

        Image(
            painter = painterResource(id = R.drawable.ic_next),
            contentDescription = "Next",
            modifier = Modifier
                .clickable { onNextSongClick() }
        )
    }
}

@Preview
@Composable
fun PreviewDivider() {
    Divider(
        modifier = Modifier
            .fillMaxWidth(1.0f)
            .clip(shape = RoundedCornerShape(10.dp))
    )
}

@Preview
@Composable
fun PreviewSongDetails() {
    SongDetails(
        name = "Song Name",
        artist = "Artist Name",
        modifier = Modifier
    )
}

@Preview
@Composable
fun PreviewSliderSeekBar() {
    SliderSeekBar(
        songUIState = SongPlayerState(
            selectedSong = SongModel(
                id = 1,
                imageUrl = "https://picsum.photos/200/300",
                name = "Song Name",
                artist = "Artist Name",
                isTopTrack = false,
                songUrl = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3"
            ),
            isPlaying = false,
            isLoading = false,
            progress = 0.5f
        ),
        onSongPlayerState = {
        },
        modifier = Modifier.fillMaxWidth(1.0f)
    )
}

@Preview
@Composable
fun PreviewSongControls() {
    SongControls(
        onPreviousSongClick = {},
        onPlayPauseClick = {},
        onNextSongClick = {},
        modifier = Modifier
            .fillMaxWidth(1.0f)
    )
}

@Preview
@Composable
fun PreviewSongPlayerScreen() {
    val viewModel: SongsListViewModel

    SongPlayerScreen(
        viewModel = viewModel()
    )
}
