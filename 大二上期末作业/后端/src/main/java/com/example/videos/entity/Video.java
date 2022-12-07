package com.example.videos.entity;

import lombok.Data;

import java.sql.Timestamp;
@Data
public class Video {
    private long id;
    private Timestamp updateTime;
    private String status;
    private String title;
    private String cover;
    private boolean isTop;
    private int uploadUser;
    private String describe;
    private String videoStyle;
    private String playUrl;
}