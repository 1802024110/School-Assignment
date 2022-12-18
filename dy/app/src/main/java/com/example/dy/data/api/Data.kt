package com.example.dy.data.repo

data class Data<T>(var code: Int, var message: String,var data : T){

}

data class TokenData(
    val access_token: String,
    val refresh_token: String,
    val redirectUrl: String,
    val expires_in: Long
)