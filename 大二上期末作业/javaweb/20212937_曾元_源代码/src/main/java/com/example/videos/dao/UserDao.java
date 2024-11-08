package com.example.videos.dao;

import com.example.videos.entity.User;
import com.example.videos.entity.Video;
import org.jvnet.hk2.annotations.Service;

import java.util.List;

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

    /**
     * 根据账号密码找用户
     * */
    User findByEmailAndPassword(String email, String password);
    /**
    * 根据邮箱找密码
    * */
    String getUserPasswordByEmail(String email);
    /**
     * 根据邮箱找用户id
     * */
    Integer getUserIdByEmail(String email);
    /**
     * 根据用户id获取提交的视频
     * */

    List<Video> getSubmitVideosByUserId(Integer userId);
    /**
     * 根据用户id获取用户喜欢的视频id列表
     * */
    List<Integer> getLikeVideosByUserId(Integer userId);

    User getUserById(String id);
}
