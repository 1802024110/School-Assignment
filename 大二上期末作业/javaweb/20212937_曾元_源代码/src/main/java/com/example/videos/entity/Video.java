package com.example.videos.entity;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Map;

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
    // 上传者的具体信息，为了保证效率，查数据库时不会自动设置
    private Map author;
}