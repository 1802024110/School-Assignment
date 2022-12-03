package com.example.videos.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class User {

  /**
   * 账号状态
   * 0正常
   * 1封禁
   * 2删除
   * */
  private long silence;
  /**
   * 用户名
   * */
  private String username;
  /**
   * 用户邮箱
   * */
  private String email;
  /**
   * 用户性别
   * 0未知
   * 1男性
   * 2女性
   * */
  private long gender;
  /**
   * 用户头像
   * */
  private String avatar;
  /**
   * 用户个人签名
   * */
  private String sign;
  /**
   * 用户等级
   * */
  private long level;
  /**
   * 用户生日
   * */
  private Date birthday;
  /**
   * 用户国家
   * */
  private String country;
  /**
   * 用户ip
   * */
  private String ip;
  /**
   * 用户密码
   * */
  private String passworld;
  /**
   * 用户收藏数
   * */
  private String focusCount;
  /**
   * 用户点赞数
   * */
  private long likeCount;
  /**
   * 用户粉丝数
   * */
  private long fansCount;
  /**
   * 用户个人主页背景
   * */
  private String backgroundImg;
  /**
   * 用户token
   * */
  private String token;
  /**
   * 用户刷新token
   * */
  private String refresh_token;
}
