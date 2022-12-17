package com.example.dy.data.repo

import com.example.dy.data.api.DyApi
import okhttp3.Response
import javax.inject.Inject

class UserRepo @Inject constructor(
    private val dyApi: DyApi
) {

    fun login(username: String,password: String) = dyApi.login(username,password)
}