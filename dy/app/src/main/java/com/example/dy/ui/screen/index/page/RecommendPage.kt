package com.example.dy.ui.screen.index.page

import android.provider.MediaStore
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dy.R

@Preview
@Composable
fun RecommendPage(){
    Box(Modifier.background(color = Color.Black)) {
        VideosList()

        TopBar()
    }
}

@Composable
fun VideosList() {

    TODO("Not yet implemented")
}

@Composable
fun TopBar(){
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