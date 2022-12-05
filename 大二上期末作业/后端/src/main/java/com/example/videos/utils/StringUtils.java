package com.example.videos.utils;

import at.favre.lib.crypto.bcrypt.BCrypt;

/**
 * 处理字符串相关的工具
 * */
public class StringUtils {
    public static String encryptionPasswd(String password){
        String bcryptHashString = BCrypt.withDefaults().hashToString(12, password.toCharArray());
        return bcryptHashString;
    }

}
