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
    public static Boolean verifyPassword(String password,String encryptionPasswd){
        // 为空会报错，所以手动处理
        if (encryptionPasswd.equals("")){
            return false;
        }
        BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), encryptionPasswd);
        return result.verified;
    }
}
