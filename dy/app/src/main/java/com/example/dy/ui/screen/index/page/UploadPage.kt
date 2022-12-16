package com.example.dy.ui.screen.index.page

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dy.R

@Preview
@Composable
fun Upload(){
    var switchState  by remember {mutableStateOf(true)}
    var videoTitle by rememberSaveable { mutableStateOf("") }
    var videoDescription by rememberSaveable { mutableStateOf("") }
    var videoStatus by rememberSaveable { mutableStateOf("") }
    var videoStyle by rememberSaveable { mutableStateOf("") }
    Scaffold(
                topBar = {
                 TopAppBar(
                     backgroundColor = Color.White,
                     title = {
                         Text("上传")
                     },
                     actions ={
                        IconButton(onClick = { switchState=!switchState}) {
                            androidx.compose.material3.Icon(
                                Icons.Outlined.RestorePage,
                                contentDescription = "切换上传方式"
                            )
                        }
                     }
                 )
        },
        content = {innerPadding ->
                 if(switchState){
                     Column(modifier = Modifier
                         .padding(innerPadding)
                         .fillMaxSize()) {
                         TextField(
                             value = videoTitle,
                             onValueChange = { videoTitle = it },
                             label ={ Text(text = "视频标题")},
                             placeholder={ Text(text = "我是练习时长两年半的个人练习生")},
                             maxLines = 1,
                             modifier = Modifier
                                 .fillMaxWidth()
                                 .padding(start = 10.dp, top = 10.dp, end = 10.dp)
                         )
                         TextField(
                             value = videoDescription,
                             onValueChange = { videoDescription = it },
                             label ={ Text(text = "视频描述")},
                             placeholder={ Text(text = "哎呦")},
                             maxLines = 3,
                             modifier = Modifier
                                 .fillMaxWidth()
                                 .padding(start = 10.dp, top = 10.dp, end = 10.dp)
                         )

                         IconButton(
                             onClick = { /*TODO*/ },
                             modifier = Modifier
                                 .fillMaxWidth()
                                 .size(220.dp)
                         ) {
                             Icon(
                                 painter = painterResource(id = R.drawable.file_upload),
                                 contentDescription = "文件上传",
                                 modifier = Modifier
                                     .padding(start = 20.dp, end = 20.dp)
                                     .fillMaxWidth()
                                     .size(200.dp)
                                     .border(
                                         2.dp,
                                         Color.DarkGray,
                                         shape = RoundedCornerShape(20.dp)
                                     )
                             )
                         }
                     }
                 }else{
                     Column(modifier = Modifier
                         .padding(innerPadding)
                         .fillMaxSize()) {
                         Text(text = "B")
                     }
                 }
        },
    )
}

