package com.example.videos.common;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class R<T> {

    private Integer code; //编码：1成功，0和其它数字为失败

    private String message; //错误信息

    private T data; //数据


    public static <T> R<T> success(T object) {
        R<T> r = new R<T>();
        r.data = object;
        r.code = 1;
        r.message = "";
        return r;
    }

    public static <T> R<T> success(T object,String message) {
        R<T> r = new R<T>();
        r.data = object;
        r.code = 1;
        r.message = message;
        return r;
    }

    public static <T> R<T> error(String message) {
        R r = new R();
        r.message = message;
        r.code = 0;
        return r;
    }



}