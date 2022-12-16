package com.example.dy.ui.screen.index

import android.graphics.fonts.FontStyle
import android.text.BoringLayout.make
import android.util.Log
import android.view.Window
import android.widget.Toast
import com.google.accompanist.pager.HorizontalPager
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Upload
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale.Companion.Fit
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.dy.R
import com.example.dy.ui.local.LocalNavController
import com.example.dy.ui.screen.index.page.RecommendPage
import com.example.dy.ui.screen.index.page.Upload
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@Composable
fun IndexScreen(navController: NavHostController) {
    // 页码状态
    val pagerState = rememberPagerState()
    // 协程作用域，确保在协程被取消时，任何已经在该作用域中启动的协程也会被取消
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        bottomBar = {
            navBar(pagerState.currentPage){
                coroutineScope.launch {
                    pagerState.scrollToPage(it)
                }
            }
        }
    ){innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
                .fillMaxSize()
        ){
            // 水平滚动布局
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.fillMaxSize(),
                count = 3,
                userScrollEnabled = true
            ) {page->
                when(page){
                    0 -> RecommendPage()
                    1 -> Upload()
                    else -> Text("当前 $page 还没有视图")
                }
            }
        }
    }
}

/**
 * 底部导航栏
 * @param currentPage 当前页面指针
 * @param scrollToPage 点击的回调会返回当前点击的页码
 * */
@Composable
fun navBar(currentPage: Int,scrollToPage: (Int)->Unit){
    // NavigationBar
    // 参考文章： https://developer.android.com/reference/kotlin/androidx/compose/material3/package-summary#navigationbar
    NavigationBar(
        modifier = Modifier.clip(shape = RoundedCornerShape(20.dp,20.dp,0.dp,0.dp))
    ) {
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Home, contentDescription = stringResource(R.string.screen_index_bottom_home)) },
            selected = currentPage == 0,
            onClick = {
                scrollToPage(0)
            },
            alwaysShowLabel = false
        )
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Upload, contentDescription = stringResource(R.string.screen_index_bottom_upload)) },
            selected = currentPage == 1,
            onClick = {
                scrollToPage(1)
            },
            alwaysShowLabel = false
        )
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Person, contentDescription = stringResource(R.string.screen_index_bottom_user)) },
            selected = currentPage == 2,
            onClick = {
                scrollToPage(2)
            },
            alwaysShowLabel = false
        )
    }
}