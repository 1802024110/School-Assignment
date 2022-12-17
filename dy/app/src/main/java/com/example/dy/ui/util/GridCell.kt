package com.example.dy.ui.util

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun adaptiveGridCell(): GridCells {
    val windowSizeClass = calculateWindowSizeClass(LocalContext.current.findActivity())
    return when(windowSizeClass.widthSizeClass) {
        WindowWidthSizeClass.Compact -> GridCells.Fixed(4)
        else -> GridCells.Adaptive(200.dp)
    }
}

@Composable
fun adaptiveStaggeredGridCell(): StaggeredGridCells {
    val windowSizeClass = calculateWindowSizeClass(LocalContext.current.findActivity())
    return when(windowSizeClass.widthSizeClass) {
        WindowWidthSizeClass.Compact -> StaggeredGridCells.Fixed(4)
        else -> StaggeredGridCells.Adaptive(200.dp)
    }
}