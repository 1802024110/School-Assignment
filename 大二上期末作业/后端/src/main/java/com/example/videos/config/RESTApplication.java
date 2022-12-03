package com.example.videos.config;

import com.example.videos.filter.MyRequestFilter;
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
        packages("com.example.videos.controller");
        register(MyRequestFilter.class);
    }
}