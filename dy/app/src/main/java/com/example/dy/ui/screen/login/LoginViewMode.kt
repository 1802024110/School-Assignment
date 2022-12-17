package com.example.dy.ui.screen.login

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewMode @Inject constructor(
    private val context: Application
) :ViewModel(){
    var userName by mutableStateOf("")
    var password by mutableStateOf("")
    val isLoginState by mutableStateOf(false)
    var errorContent by mutableStateOf("")
}