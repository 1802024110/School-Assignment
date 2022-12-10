package com.example.videos.entity;

import lombok.Data;

@Data
public class Comment {

  private long id;
  private long userId;
  private String content;
  private java.sql.Timestamp createdAt;
  private java.sql.Timestamp updatedAt;
  private long isDeleted;
  private String videoId;
  private long likes;
  private long parentId;
  private long targetCommentId;
  private String ip;
}
