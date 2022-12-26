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
     * */
    List<Video> getStyleVideos(List<Integer> video_style,Integer page);
    /**
     * 根据视频类型列表获得该类型视频的总数
     * */
    Integer getVideoCountByStyles(List<Integer> styles);
    /**
     * 随机返回10个状态为正常的视频
     * */
    List<Video> getRandomVideos();

    /**
     * 根据视频id获得上传者(作者信息)
     * */
    User getUserByVideoID(Integer id);
}
