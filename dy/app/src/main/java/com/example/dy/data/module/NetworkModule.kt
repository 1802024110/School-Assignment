package com.example.dy.data.module

import com.example.dy.data.api.UserApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

private const val TIMEOUT = 15_000L

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideDyService() : UserApi = Retrofit.Builder()
        .baseUrl("http://10.71.17.74:8080/videos_war/api/user/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(UserApi::class.java)
}