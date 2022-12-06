package com.example.videos.dao;

import com.example.videos.entity.User;
import org.jvnet.hk2.annotations.Service;

public interface UserDao {
    /**
     *  添加用户
    * */
    void add(User user);
    /**
     * 根据email查找用户
     * */
    User getUserByEmail(String email);

    /**
     * 添加用户
     * @param user 用户实体
     * */
    Integer insertUser(User user);

    User findByEmailAndPassword(String email, String password);
    String getUserPasswordByEmail(String email);
}
