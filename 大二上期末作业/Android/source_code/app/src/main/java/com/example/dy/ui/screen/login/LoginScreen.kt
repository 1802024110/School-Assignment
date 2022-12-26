package com.example.dy.ui.screen.login

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.outlined.Code
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Password
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.dy.R
import com.example.dy.ui.theme.Pink80
import com.example.dy.ui.theme.Purple80
import com.example.dy.ui.theme.PurpleGrey80


@Composable
fun LoginScreen(navController: NavController, loginViewModel: LoginViewModel = hiltViewModel()){
    val context = LocalContext.current
    // 登录进度对话框
    var progressDialog by remember {
        mutableStateOf(false)
    }
    if(progressDialog){
        AlertDialog(
            onDismissRequest = { progressDialog = false },
            title = {
               Text(text = "登录中...")
            },
            icon = {
                CircularProgressIndicator(Modifier.size(30.dp))
            },
            text = {
                Text("请等待一会")
            },
            confirmButton = {}
        )
    }

    // 登录失败
    var failedDialog by remember {
        mutableStateOf(false)
    }
    if(failedDialog) {
        AlertDialog(
            onDismissRequest = { failedDialog = false},
            title = {
                Text("登录错误")
            },
            text = {
                Text(loginViewModel.errorContent)
            },
            confirmButton = {
                TextButton(
                    onClick = { failedDialog = false }
                ) {
                    Text("好的")
                }
            }
        )
    }


    var switchPage by remember { mutableStateOf(true) }
    var privacyPolicyState by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp, end = 20.dp)
    ) {
        Box(modifier = Modifier.padding(top = 60.dp)){
            Logo()
        }
        Column (
            modifier = Modifier.padding(top = 10.dp)
                ){
            if(switchPage){
                pageStateText("Sing Up")
            }else{
                pageStateText("Register")
            }
            loginAdnRegisterButton(switchPage){
                switchPage = it
            }
        }
        Column(){
            if (switchPage){
                Column(
                    modifier = Modifier.padding(top =60.dp)
                ) {
                    inputText(loginViewModel.email,"Email", Icons.Outlined.Email){loginViewModel.email=it}
                    inputText(loginViewModel.password,"Password", Icons.Outlined.Password){loginViewModel.password=it}
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = privacyPolicyState,
                        onClick = { privacyPolicyState = !privacyPolicyState },
                    )
                    Text(
                        "我已阅读并同意用户须知",
                        fontSize = 20.sp
                    )
                    Spacer(modifier = Modifier.weight(1f))

                    TextButton(onClick = { /*TODO*/ }) {
                        Text(
                            text = "忘记密码?"
                        )
                    }
                }
            }else{
                Row(
                    verticalAlignment = Alignment.Bottom
                ) {
                    Box(
                        modifier = Modifier.weight(2f)
                    ) {
                        inputText(loginViewModel.email,"Email", Icons.Outlined.Email){loginViewModel.email=it}
                    }
                    Box(
                        modifier = Modifier.weight(1f)
                    ) {
                        Button(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp),
                            onClick = { /*TODO*/ }
                        ) {
                            Text(text = "Send Code")
                        }
                    }
                }
                inputText(loginViewModel.userName,"Name",Icons.Outlined.Person){loginViewModel.userName=it}
                inputText(loginViewModel.password,"Password", Icons.Outlined.Password){loginViewModel.password=it}
                inputText(loginViewModel.code,"Code",Icons.Outlined.Code){loginViewModel.code=it}
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = privacyPolicyState,
                        onClick = { privacyPolicyState = !privacyPolicyState },
                    )
                    Text(
                        "我已阅读并同意用户须知",
                        fontSize = 20.sp
                    )
                }
            }
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.BottomEnd
            ){
                FloatingActionButton(
                    onClick = {
                        if(loginViewModel.email.isBlank()||loginViewModel.password.isBlank()) {
                            Toast.makeText(
                                context,
                                "用户名或密码不能为空",
                                Toast.LENGTH_SHORT
                            ).show()
                            return@FloatingActionButton
                        }

                        if (!privacyPolicyState){
                            failedDialog = true
                            loginViewModel.errorContent = "未同意用户须知"
                            return@FloatingActionButton
                        }

                        progressDialog = true
                        loginViewModel.login(){
                            if(it){
                                navController.navigate("index")
                            }else{
                                progressDialog = false
                                failedDialog = true
                            }
                        }
                          },
                    modifier = Modifier.padding(end = 12.dp, bottom = 32.dp)
                ) {
                    Icon(Icons.Filled.Done, "确认")
                }
            }
        }
    }
}

@Composable
fun inputText(text: String,title: String,image: ImageVector,callback:(newValue:String)->Unit) {
    Column(
        Modifier
            .padding(top = 20.dp)
            .background(Color.White)
            .fillMaxWidth()) {
        TextField(
            value = text,
            onValueChange = { callback(it) },
            label = { Text(title) },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                focusedIndicatorColor = Color.Blue,
                unfocusedIndicatorColor = Color.Red
            ),
            trailingIcon = {
                Icon( image, contentDescription = title)
            },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun loginAdnRegisterButton(switchPage:Boolean,callback:(switch:Boolean)-> Unit){
    var switchPage by remember { mutableStateOf(switchPage) }

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()

    ) {
        IconButton(
            modifier = Modifier
                .size(160.dp, 80.dp)
                .background(if (switchPage) Pink80 else PurpleGrey80, RoundedCornerShape(10.dp))
            ,

            onClick = {
                switchPage = true
                callback(switchPage)
            }
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    Icons.Outlined.Person,
                    contentDescription = "登录",
                    modifier = Modifier.size(32.dp)
                )
                Text(
                    text = "登录",
                    fontSize = 24.sp
                )
            }
        }
        IconButton(
            modifier = Modifier
                .size(160.dp, 80.dp)
                .background(if (switchPage) PurpleGrey80 else Pink80, RoundedCornerShape(10.dp))
            ,

            onClick = {
                switchPage = false
                callback(switchPage) }
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    painterResource(
                        id = R.drawable.register),
                    contentDescription = "注册",
                    modifier = Modifier.size(32.dp)
                )
                Text(
                    text = "注册",
                    fontSize = 24.sp
                )
            }
        }
    }
}

@Composable
fun pageStateText(text: String){
    Text(
        fontSize = 80.sp,
        color = Purple80,
        text = text,
        modifier = Modifier
    )
}

@Composable
fun Logo(){
    Row(
        verticalAlignment  = Alignment.Bottom,
        modifier = Modifier.fillMaxWidth()
    ) {
        Icon(
            painterResource(id = R.drawable.logo),
            "应用logo",
            modifier = Modifier
                .size(80.dp)
                .background(PurpleGrey80, RoundedCornerShape(50.dp))
        )
        Text(
            fontSize = 60.sp,
            text = "NoDream",
            modifier = Modifier.padding(start = 2.dp)
        )
    }
}