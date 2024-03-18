package com.yash10019coder.musicplayerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yash10019coder.musicplayerapp.ui.compose.songplayer.SongPlayerScreen
import com.yash10019coder.musicplayerapp.ui.compose.songslist.SongList
import com.yash10019coder.musicplayerapp.ui.theme.MusicPlayerAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            MusicPlayerAppTheme {
                NavHost(
                    navController = navController,
                    startDestination = "songs"
                ) {
                    composable("songs") {
                        SongList()
                    }
                }
            }
        }
    }
}
