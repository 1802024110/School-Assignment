package com.example.videos.service;

// 公共接口的服务
public interface PublicService {
    Boolean setCodeByEmail(String code, String email);
    Boolean checkCodeByEmail(String code, String email);

}
