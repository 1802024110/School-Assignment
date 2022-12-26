package com.example.dy.ui.util

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalLayoutDirection

// 拓展方法
@Composable
operator fun PaddingValues.plus(other: PaddingValues): PaddingValues =
    PaddingValues(
        top = calculateTopPadding() + other.calculateTopPadding(),
        bottom = calculateBottomPadding() + other.calculateBottomPadding(),
        start = calculateStartPadding(LocalLayoutDirection.current) + other.calculateStartPadding(LocalLayoutDirection.current),
        end = calculateEndPadding(LocalLayoutDirection.current) + other.calculateEndPadding(LocalLayoutDirection.current)
    )