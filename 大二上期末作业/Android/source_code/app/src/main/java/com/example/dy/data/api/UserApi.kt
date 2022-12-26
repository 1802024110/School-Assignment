package com.example.dy.data.api

import com.example.dy.data.repo.Data
import com.example.dy.data.repo.TokenData
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
// 参考文章: https://juejin.cn/post/6978777076073660429
interface UserApi {
    @FormUrlEncoded
    @POST("oauth/access_token")
    fun login(@Field("email") email: String,@Field("password") password: String) : Call<Data<TokenData>>
}