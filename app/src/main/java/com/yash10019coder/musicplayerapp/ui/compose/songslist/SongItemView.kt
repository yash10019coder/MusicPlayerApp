package com.yash10019coder.musicplayerapp.ui.compose.songslist

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.BrushPainter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage


@Composable
fun SongItemView(imageUrl: String, songName: String, artistName: String, onSongClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(20.dp, 12.dp)
            .fillMaxWidth(1.0f)
            .clickable(onClick = onSongClick)
            .background(color = MaterialTheme.colorScheme.surface)
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = "Artist Image",
            modifier = Modifier
                .padding(0.dp, 0.dp, 16.dp, 0.dp)
                .size(48.dp)
                .clip(CircleShape),
            contentScale = androidx.compose.ui.layout.ContentScale.Crop,
            placeholder = BrushPainter(
                Brush.linearGradient(
                    listOf(
                        Color(color = 0xFFFFFFFF),
                        Color(color = 0xFFDDDDDD),
                    )
                )
            ),
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
    SongItemView(
        imageUrl = "https://picsum.photos/200/300",
        songName = "Song Name",
        artistName = "Artist Name",
        onSongClick = {}
    )
}
