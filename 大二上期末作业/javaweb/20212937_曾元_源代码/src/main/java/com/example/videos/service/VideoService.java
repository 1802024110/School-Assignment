package com.example.videos.service;

import com.example.videos.entity.Video;

import java.util.List;
import java.util.Map;

public interface VideoService {
    Video getVideoById(Integer videoId);

    Map<String,Object> getVideoByKey(String keyword, Integer page);

    Map<String, Object> getVideoRecommended(String token,Integer page);

    List<Video> getRandomVideos();
}
