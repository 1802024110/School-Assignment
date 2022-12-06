package com.example.videos.filter;

import com.example.videos.common.R;
import com.example.videos.dao.UserDao;
import com.example.videos.dao.imp.UserDaoImp;
import com.example.videos.note.AuthCheck;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * 检查请求是否携带token
 * 参考文章: https://blog.csdn.net/qq_28334711/article/details/72925495
* */
@Provider
@AuthCheck
public class UserAuthFilter implements  ContainerResponseFilter {
    public void filter(final ContainerRequestContext requestContext, final ContainerResponseContext responseContext) throws IOException {
        String token = requestContext.getHeaderString("Authorization");
        if (token.equals("")) {
            responseContext.setEntity(R.error("身份验证错误"));
        }
    }
}
