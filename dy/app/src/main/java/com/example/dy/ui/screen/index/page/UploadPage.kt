package com.example.dy.ui.screen.index.page

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Save
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.dy.R

@Composable
fun Upload(){
    var switchState  by remember {mutableStateOf(true)}
    var videoTitle by rememberSaveable { mutableStateOf("") }
    var videoDescription by rememberSaveable { mutableStateOf("") }
    var videoUrl by rememberSaveable { mutableStateOf("") }

    var dialogState by rememberSaveable { mutableStateOf(false) }
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
                    if(dialogState){
                        Dialog(
                            onDismissRequest = {},
                            properties = DialogProperties(false,false)
                        ) {
                            Box(
                                modifier = Modifier.size(300.dp,100.dp)
                                    .background(Color.Black.copy(0.6f),shape = RoundedCornerShape(20.dp))
                            ){
                                Text(
                                    "正在保存..",
                                    color = Color.White,
                                    modifier = Modifier.padding(10.dp)
                                    )
                            }

                        }
                    }
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

                         if(switchState){
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
                         }else{
                             TextField(
                                 value = videoUrl,
                                 onValueChange = { videoUrl = it },
                                 label ={ Text(text = "视频播放链接")},
                                 placeholder={ Text(text = "给我看看!")},
                                 maxLines = 3,
                                 modifier = Modifier
                                     .fillMaxWidth()
                                     .padding(start = 10.dp, top = 10.dp, end = 10.dp)
                             )
                         }

                         Box(
                             modifier = Modifier.fillMaxSize(),
                             contentAlignment = Alignment.BottomEnd
                         ){
                             FloatingActionButton(
                                 onClick = { dialogState = true },
                                 modifier = Modifier.padding(end = 8.dp, bottom = 8.dp)
                             ) {
                                 Icon(Icons.Filled.Save, "提交上传")
                             }
                         }
                     }
        },
    )
}

@Composable
fun styleButton(style:String,callback:(style:String)->Unit) {
    TextButton({callback(style)},
        modifier = Modifier.border(2.dp, Color.Gray.copy(0.8f),shape= RoundedCornerShape(20.dp))
    ) {
        Text(text = style)
    }
}
