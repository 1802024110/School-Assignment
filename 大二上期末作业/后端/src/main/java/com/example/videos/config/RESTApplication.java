package com.example.videos.config;

import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * Jersey的配置文件
 * 参考文章1: https://www.codenong.com/45625925/
 * 参考文章2: https://github.com/majxbear/jetty-rest
* */
@ApplicationPath("api")
public class RESTApplication extends ResourceConfig {

    public RESTApplication() {
        // 注册控制器
        packages("com.example.videos.controller");
        // 注册错误处理
        packages("com.example.videos.exception");
        // 注册过滤器
        packages("com.example.videos.filter");
    }
}