package com.example.dy.ui.screen.index.page

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Person
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

@Preview
@Composable
fun MyPage(){
    var selectedTabIndex by remember { mutableStateOf(0) }

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

                TabRow(selectedTabIndex = selectedTabIndex) {
                    Tab(selected = selectedTabIndex == 0, onClick = { selectedTabIndex = 0}) {
                        Text("投稿")
                    }
                    Tab(selected = selectedTabIndex == 1, onClick = { selectedTabIndex = 1}) {
                        Text("喜欢的视频")
                    }
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
@Preview
@Composable
fun videoCardView(){
    Box(
        modifier = Modifier.size(80.dp,100.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.user_background),
            contentDescription = "视频描述",
            contentScale = ContentScale.Crop
        )
        Row(
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier.padding(top=90.dp)
        ) {
            Icon(
                Icons.Filled.Favorite,
                contentDescription = "点赞数",
                modifier = Modifier.size(10.dp)
            )
            Text(
                text = "452k",
                fontSize = 7.sp
            )
        }
    }    
}