package xyz._007666.mybatis.entity;

import lombok.Data;

@Data
public class Comment {

  private long id;
  private long userId;
  private String commentText;
}
