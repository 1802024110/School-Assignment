package com.example.videos.entity;

import lombok.Data;

import java.beans.Transient;
@Data
public class Comment {

  private long id;
  private long userId;
  private String content;
  private java.sql.Timestamp createdAt;
  private long isDeleted;
  private String videoId;
  private long likes;
  private long parentId;
  private String ip;
}
