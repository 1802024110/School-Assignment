package com.example.videos.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
    /**
     * 毫秒转日期
    */
    public static String MillisecondsToDate(long millis) {
        Date date = new Date();
        date.setTime(millis);
        return new SimpleDateFormat("yyyy-MM-dd HH:ss:mm").format(date);
    }

    /**
     * 获得token过期时间
     * */
    public static String getTokenExpression(){
        return TimeUtil.MillisecondsToDate(System.currentTimeMillis() + TokenUtils.EXPIRE_DATE);
    }
}
