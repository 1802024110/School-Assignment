package com.example.videos.dao;

import com.example.videos.entity.User;
import org.jvnet.hk2.annotations.Service;

public interface UserDao {
    /**
     *  添加用户
    * */
    void add(User user);
    /**
     * 根据token查找用户
    * */
    User getUserByToken(String token);
    /**
     * 根据email查找用户
     * */
    User getUserByEmail(String email);
}
