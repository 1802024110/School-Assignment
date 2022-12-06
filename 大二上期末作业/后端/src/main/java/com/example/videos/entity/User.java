package com.example.videos.entity;

import com.example.videos.utils.OtherUtil;
import lombok.Data;

import java.lang.reflect.Field;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

@Data
public class User {
  private long id;

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
  private String password;
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
  /**
   * 用户电话号码
   * */
  private long tel;

  /**
   * 获得公开信息
  * */

  public Map<String, Object> getPublicInfo() {
    Map<String, Object> info = OtherUtil.objectToMap(this);
    // 移除掉敏感信息
    info.remove("token");
    info.remove("refresh_token");
    info.remove("password");
    info.remove("id");
    return info;
  }
}
