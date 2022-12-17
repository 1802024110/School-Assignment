package com.example.dy.ui.screen.index.page

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dy.R
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.CoroutineScope

@Preview
@Composable
fun MyPage(){
    var selectedTabIndex = rememberPagerState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(){
            Image(
                painter = painterResource(id = R.drawable.user_background),
                contentDescription = "用户背景",
                modifier = Modifier.fillMaxWidth()
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 200.dp)
                    .background(Color.White, RoundedCornerShape(20.dp, 20.dp))
            ) {
                Text(
                    "梦无念",
                    fontSize = 26.sp,
                    modifier = Modifier.padding(top = 60.dp, start = 25.dp)
                )
                Text(
                    "用户id: 1",
                    fontSize = 12.sp,
                    maxLines = 1,
                    modifier = Modifier.padding( start = 25.dp,top=6.dp)
                )

                TabRow(selectedTabIndex = selectedTabIndex.currentPage) {
                    val scope: CoroutineScope = rememberCoroutineScope()
                    Tab(selected = selectedTabIndex.currentPage == 0, onClick = { }) {
                        Text("投稿")
                    }
                    Tab(selected = selectedTabIndex.currentPage == 1, onClick = { }) {
                        Text("喜欢的视频")
                    }
                }
                HorizontalPager(
                    count = 2,
                    state = selectedTabIndex,
                    modifier = Modifier.fillMaxSize()
                ) {
                    OrenoList()
                }
            }
            Row(
                modifier = Modifier
                    .padding(start = 25.dp, top = 180.dp)
                    .fillMaxWidth()
                    .height(80.dp)
            ){
                Image(painter = painterResource(id = R.drawable.user_background),
                    contentDescription = "用户头像",
                    contentScale=  ContentScale.FillBounds,
                    modifier = Modifier
                        .size(80.dp)
                        .border(5.dp, Color.White, RoundedCornerShape(80.dp))
                        .clip(RoundedCornerShape(80.dp))
                )
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f)
                ) {
                    Text(
                        "获赞",
                        fontSize = 16.sp
                    )
                    Text(
                        "5",
                        fontSize = 12.sp
                    )
                }
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f)
                ) {
                    Text(
                        "关注",
                        fontSize = 16.sp
                    )
                    Text(
                        "60",
                        fontSize = 12.sp
                    )
                }
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f)
                ) {
                    Text(
                        "粉丝",
                        fontSize = 16.sp
                    )
                    Text(
                        "5",
                        fontSize = 12.sp
                    )
                }
            }
        }
    }
}

@Composable
fun OrenoList() {
    val listState = rememberLazyGridState()
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        state = listState,
        modifier = Modifier.fillMaxHeight()
    ){
        items(
            count =  7
        ){
            videoCardView(imageResource = R.drawable.user_background, likesCount = "2323k")
        }
    }
}

@Composable
fun videoCardView(@DrawableRes imageResource: Int,likesCount:String,description:String="这个人很懒，没有描述"){
    ElevatedCard(
        // 覆盖掉自带的圆角
        shape = RoundedCornerShape(0.dp),
        onClick = {
                  TODO("")
        },
        modifier = Modifier
            .size(80.dp, 180.dp)
            .padding(1.dp)
    ) {
        Box {
            Image(
                painter = painterResource(id = imageResource),
                contentDescription = description,
                contentScale = ContentScale.Crop
            )
            Row(
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier.padding(top=160.dp, start = 2.dp)
            ) {
                Icon(
                    Icons.Outlined.Favorite,
                    contentDescription = "点赞数",
                    modifier = Modifier.size(14.dp)
                )
                Text(
                    text = likesCount,
                    fontSize = 11.sp,
                    modifier = Modifier.padding(start=2.dp)
                )
            }
        }
    }    
}