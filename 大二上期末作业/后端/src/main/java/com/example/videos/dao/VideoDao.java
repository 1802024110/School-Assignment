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
}
