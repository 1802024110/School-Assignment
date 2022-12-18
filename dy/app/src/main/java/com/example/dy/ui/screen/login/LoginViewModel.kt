package com.example.dy.ui.screen.login

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dy.data.api.UserApi
import com.example.dy.data.repo.Data
import com.example.dy.data.repo.TokenData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val userApi: UserApi,
    private val context: Application
) :ViewModel(){
    private val TAG = "LoginViewModel"
    var email by mutableStateOf("1802024110@qq.com")
    var userName by mutableStateOf("")
    var password by mutableStateOf("2002zyuan")
    var code by mutableStateOf("")
    var isLoginState by mutableStateOf(false)
    var errorContent by mutableStateOf("")

    fun login(result:(success:Boolean)->Unit) {
        viewModelScope.launch {
            isLoginState = true
            userApi.login(email, password).enqueue(object:Callback<Data<TokenData>>{
                override fun onResponse(
                    call: Call<Data<TokenData>>,
                    response: Response<Data<TokenData>>
                ) {
                    val body = response.body()
                    body?.let {
                        if (body.code == 1){
                            result(true)
                        }
                        else {
                            result(false)
                            errorContent = body.message
                        }
                    }
                }

                override fun onFailure(call: Call<Data<TokenData>>, t: Throwable) {
                    result(false)
                    errorContent = t.toString()
                }

            })
        }
    }
}