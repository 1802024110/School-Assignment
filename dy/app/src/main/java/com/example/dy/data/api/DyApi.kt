package com.example.dy.data.api

interface DyApi {
    /**
     * 登录
     *
     * @param username 登录用户名
     * @param password 登录密码
     * @return token cookie
     * */

    fun login(username: String, password: String)
}