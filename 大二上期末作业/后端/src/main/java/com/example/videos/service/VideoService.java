package com.example.videos.service;

import com.example.videos.entity.Video;

import java.util.List;

public interface VideoService {
    Video getVideoById(Integer videoId);

    List<Video> getVideoByKey(String keyword, Integer page);
}
