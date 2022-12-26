package com.example.dy.ui.screen.index.page

import android.util.Log
import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material.rememberSwipeableState
import androidx.compose.material.swipeable
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dy.R
import com.example.dy.data.DummyData
import com.example.dy.ui.component.VideoPlayer
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.VerticalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import com.google.android.gms.analytics.AnalyticsService

@Composable
fun RecommendPage() {
    Box(
        Modifier
            .background(color = Color.White)
            .fillMaxHeight()
    ) {
        VideosList()

        TopBar()
    }
}

@Composable
fun VideosList() {
    val reels = DummyData.reels
    VerticalPager(
        count = reels.size,
    ) {page->
        val that = this
        Box(
            Modifier
                .fillMaxHeight(),
            contentAlignment = Alignment.Center
        ){
            if (page==that.currentPage){
                VideoPlayer(reels[page].getVideoUrl())
            }
            Box(
                Modifier.fillMaxHeight(),
                contentAlignment = Alignment.BottomEnd
            ) {
                Statistic()
            }
        }
    }
}

@Composable
fun Statistic(){
    Column(
        horizontalAlignment =  Alignment.End,
        modifier = Modifier.fillMaxWidth()
            .padding(bottom = 24.dp)
    ) {
        IconButton(
            onClick = { /*TODO*/ },
            modifier = Modifier.size(60.dp)

        ) {
            Icon(
                Icons.Outlined.Person,
                contentDescription="我的信息",
                modifier = Modifier.size(60.dp)
                    .clip(shape = RoundedCornerShape(60.dp))
            )
        }
        Column(
            Modifier.offset(-6.dp,0.dp)
        ){
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Outlined.Favorite,contentDescription="喜欢")
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Outlined.Message,contentDescription="评论")
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Outlined.Download,contentDescription="下载")
            }
        }
        Row() {
            Column(
                modifier = Modifier.weight(9f)
            ) {
                Text(text = "@默认用户",fontSize=20.sp)
                Text(text = "一堆为满足考多少分螺丝钉咖啡碱立刻电视机反抗类dsfadfsfsdsdfsdfsdfsdsdfdssdfsddsfsdfsdsdfdsfsdfdsdsfsdfdsfdsfdsdsfsdfsdfdsfd毒素",
                    fontSize=15.sp,
                    maxLines=2,
                    lineHeight=24.sp)
            }
            IconButton(onClick = { /*TODO*/ }, modifier = Modifier.weight(1f).offset(-11.dp,0.dp)) {
                Icon(Icons.Outlined.More,contentDescription="更多")
            }
        }
    }
}

@Composable
fun TopBar() {
    //val navController = LocalNavController.current
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
            ) {
                Row(
                    modifier = Modifier
                        .weight(5f)
                        .offset(35.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    TextButton(onClick = { /*TODO*/ }) {
                        Text(
                            fontSize = 20.sp,
                            text = stringResource(R.string.screen_index_bottom_text_like),
                        )
                    }

                    Divider(
                        modifier = Modifier
                            .padding(top = 13.dp, bottom = 9.dp)
                            .fillMaxHeight()
                            .width(1.dp)
                    )

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
                    Icon(
                        Icons.Outlined.Search,
                        contentDescription = stringResource(R.string.screen_index_bottom_search)
                    )
                }
            }
        }
    )
}