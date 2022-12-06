package com.example.videos.dao;

import com.example.videos.entity.User;

import java.util.List;
import java.util.Map;

public interface VideoDao {
    /**
     * 用户投稿的视频id
     * */
    List<Integer> getUserVideosId(User user);
    /**
     * 用户喜欢的视频id
     * */
    List<Integer> getLikeVideosId(User user);
}
