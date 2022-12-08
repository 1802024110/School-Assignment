package com.example.videos.dao;

import com.example.videos.entity.User;
import com.example.videos.entity.Video;

import java.util.List;
import java.util.Map;

public interface VideoDao {
    /**
     * 根据视频id获得视频
     * */
    Video getVideoById(Integer id);

    List<Video> getVideoByKey(String keyword, Integer page);

    Integer getVideoCountByKey(String keyword);
    /**
     * 获得用户喜欢视频类型列表
     * @param userId
     * @return List<Integer>
     * */
    List<Integer> getUserLikeStyles(Integer userId);

    /**
     * 根据视频类型获取视频
     * @param video_style
     * */
    List<Video> getStyleVideos(List<Integer> video_style,Integer page);

    Integer getVideoCountByStyles(List<Integer> styles);
}
