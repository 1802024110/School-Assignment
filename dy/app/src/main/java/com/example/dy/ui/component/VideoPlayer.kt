package com.example.dy.ui.component

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import xyz.doikki.videoplayer.player.BaseVideoView.OnStateChangeListener
import xyz.doikki.videoplayer.player.VideoView
import xyz.doikki.videoplayer.player.VideoViewManager


@Composable
fun VideoPlayer(url: String) {
    val TAG ="VideoPlayer"
    val context = LocalContext.current
    val dkPlayer = VideoView(context)
        DisposableEffect(AndroidView(factory = {
            dkPlayer.apply {
                release()
                setUrl(url)
                start()
            }
        }
        )){
            onDispose { dkPlayer.release() }
        }
}
