package com.yash10019coder.musicplayerapp.ui.compose.common

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ProgressLoader(isLoading: Boolean) {
    if (isLoading) {
        // Show progress bar
    } else {
        // Hide progress bar
    }
}

@Composable
fun ProgressBar() {
    CircularProgressIndicator(
        color = MaterialTheme.colorScheme.primary,
        modifier = androidx.compose.ui.Modifier
            .size(50.dp)
            .padding(10.dp),
        strokeWidth = 5.dp,
        trackColor = MaterialTheme.colorScheme.onPrimary
    )
}

@Preview
@Composable
fun ProgressBarPreview() {
    ProgressBar()
}
