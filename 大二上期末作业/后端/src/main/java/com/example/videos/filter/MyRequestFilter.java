package com.example.videos.filter;

import com.example.videos.common.R;
import jakarta.annotation.Priority;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.container.*;
import jakarta.ws.rs.ext.Provider;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
@Provider
@PreMatching
public class MyRequestFilter implements ContainerRequestFilter {
    @Override
    public void filter(ContainerRequestContext req) throws IOException {
        String path = req.getUriInfo().getPath();
        //记录请求信息:请求方法、路径
        System.out.println(req.getMethod());
        System.out.println(path);
        // 根据条件进行转发
//        if (path.contains("/api/v1.0/xx")) {
//            req.setRequestUri(URI.create("/xx"));
//        }
    }
}