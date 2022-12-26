package com.example.videos.dao;

public interface  PublicDao {

    Boolean saveCodeByEmail(String encryptCode, String email);
    String getCodeByEmail(String email);
}
