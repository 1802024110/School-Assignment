package com.example.dy.ui.screen.index

import android.graphics.fonts.FontStyle
import android.view.Window
import android.view.WindowManager
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Upload
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
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

@Composable
fun IndexScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopBar()
        },
        bottomBar = {
            navBar(0){}
        }
    ){innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ){

        }
    }
}

@Composable
fun TopBar(){
    val navController = LocalNavController.current
    // md3的顶部导航
    TopAppBar(
        // 设置背景色透明
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Color.Transparent.copy(0f)
        ),
        // 固定高度，因为它不会自己算
        modifier = Modifier.height(40.dp),
        title = {},
        actions = {
            Row(
                modifier = Modifier
                    .height(IntrinsicSize.Min)
                    .fillMaxWidth(),
            ){
                Row(
                    modifier = Modifier
                        .weight(5f)
                        .offset(35.dp),
                    horizontalArrangement = Arrangement.Center
                ){
                    TextButton(onClick = { /*TODO*/ }) {
                        Text(
                            fontSize = 20.sp,
                            text = stringResource(R.string.screen_index_bottom_text_like),
                        )
                    }

                    Divider(modifier = Modifier
                        .padding(top = 13.dp, bottom = 9.dp)
                        .fillMaxHeight()
                        .width(1.dp))

                    TextButton(onClick = { /*TODO*/ }) {
                        Text(
                            fontSize = 20.sp,
                            text = stringResource(R.string.screen_index_bottom_text_recommend)
                        )
                    }
                }
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(Icons.Outlined.Search, contentDescription = stringResource(R.string.screen_index_bottom_search))
                }
            }
        }
    )
}

/**
 * 底部导航栏
 * @param currentPage 当前页面指针
 * @param scrollToPage 点击的回调会返回当前点击的页码
 * */
@Composable
fun navBar(currentPage: Int=0,scrollToPage: (Int)->Unit){
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
            }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Upload, contentDescription = stringResource(R.string.screen_index_bottom_upload)) },
            selected = currentPage == 1,
            onClick = {
                scrollToPage(1)
            }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Person, contentDescription = stringResource(R.string.screen_index_bottom_user)) },
            selected = currentPage == 2,
            onClick = {
                scrollToPage(2)
            }
        )
    }
}