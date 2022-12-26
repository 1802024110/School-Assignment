package com.example.videos.service;

import com.example.videos.entity.User;
import com.example.videos.entity.Video;

import java.util.List;
import java.util.Map;

public interface UserService {
    Boolean saveUser(User user);
    User getUserByEmailAndPassword(String email, String password);
    /**
     * 根据邮箱查找用户
     * */
    User getUserByEmail(String email);
    User login(String email, String password);
    /**
     * 根据token生成返回体
     * */
    Map<String,Object> createTokenMap(String token);
    /**
     * 根据refresh_token生成返回体
     * */
    Map<String,Object> createreRreshTokenMap(String token);

    /**
     * 根据token获取用户信息
     * */
    User getUserByToken(String token,String id);

    List<Video> getUserSubmitVideos(String token);

    List<Video> getUserLikeVideos(String token);
}
