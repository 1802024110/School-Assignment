package com.example.videos.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 各种需要使用得正则表达式
 * */
@Slf4j
public class RegularUtils {
    /**
     * 检查邮箱格式
     * @Param string email 需要检查的邮箱
     * @return Boolean true为符合标准
     * */
    public static boolean checkEmail(String email) {
        // 定义正则表达式
        Pattern emailRegex = Pattern.compile("^[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$");
        // 创建匹配器
        Matcher m = emailRegex.matcher(email);
        // 返回尝试匹配的结果
        return m.matches();
    }
    /**
     * 检查密码格式
     * 长度在5~17之间，只能包含字母、数字和下划线
     * */
    public static boolean checkPassword(String password) {
        Pattern emailRegex = Pattern.compile("\\w{5,17}$");
        Matcher m = emailRegex.matcher(password);
        return m.matches();
    }
}
