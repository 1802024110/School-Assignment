package com.example.videos.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 这里放不知道叫什么的工具函数
 * */
public class OtherUtil {
    public static Map<String, Object> objectToMap(Object object){
        Map<String,Object> dataMap = new HashMap<>();
        Class<?> clazz = object.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            try {
                field.setAccessible(true);
                dataMap.put(field.getName(),field.get(object));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return dataMap;
    }
}
