package com.example.videos.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class UserVideoLike {
    private Long id;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Boolean deleted;
    private String ip;
    private Long videoId;
    private Long userId;
}
