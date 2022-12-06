package com.example.videos.service;

import com.example.videos.entity.User;

import java.util.Map;

public interface UserService {
    Boolean saveUser(User user);
    User getUserByEmailAndPassword(String email, String password);
    Boolean updateTokenAndRefreshTokenByEmail(String email, String token,String refreshToken);


    User login(String email, String password);

    Map<String,String> refreshToken(String refreshToken);
}
