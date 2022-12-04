package com.example.videos.controller;

import com.alibaba.druid.util.StringUtils;
import com.example.videos.common.R;
import com.example.videos.utils.ValidateCodeUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;

import java.util.Map;

@Path("public")
public class PublicController {
    @GET
    @Path("getCode/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public R<String> getCode(@PathParam("email") String email, @Context HttpServletRequest req) {
        if (!StringUtils.isEmpty(email)) {
            // 生成验证码
            String code = ValidateCodeUtils.generateValidateCode4String(4).toString();
            // 获得session
            HttpSession session = req.getSession();
            // 设置code到session
            session.setAttribute(email,code);
            // 发送邮件

            return R.success(null,"验证码发送成功"+code);
        }
        return  R.error("验证码发送失败");
    }
}
