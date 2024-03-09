package com.yash10019coder.musicplayerapp.compose.songslist

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yash10019coder.musicplayerapp.R


@Composable
fun SongCard(image: Painter, songName: String, artistName: String, onSongClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(20.dp, 12.dp)
            .clickable(onClick = onSongClick)
    ) {
        Image(
            painter = image,
            contentDescription = "Artist Image",
            modifier = Modifier
                .padding(0.dp, 0.dp, 16.dp, 0.dp)
                .size(48.dp)
                .clip(CircleShape)
        )
        Column {
            Text(
                text = songName,
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = artistName,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Preview
@Composable
fun SongCardPreview() {
    SongCard(
        image = painterResource(id = R.drawable.ic_song_cover_thumbnail),
        songName = "Song Name",
        artistName = "Artist Name",
        onSongClick = {}
    )
}
