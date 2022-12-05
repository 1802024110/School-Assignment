package com.example.videos.controller;

import com.example.videos.common.R;
import com.example.videos.note.UserLogger;
import com.example.videos.utils.RegularUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户Api
 * 参考文章: https://www.bloghome.com.cn/post/jersey-kai-fa-restful-ba-jerseycan-shu-bang-ding.html
 * */
@Path("user")
@Slf4j
@Produces(MediaType.APPLICATION_JSON)
public class UserController {

    @POST
    @Path("register")
    public R<Map> register(
            @FormParam("email") String email,
            @FormParam("password") String password,
            @FormParam("code") String code,
            @FormParam("nickName") String nickname,
            @FormParam("tel") String tel,
            @Context HttpServletRequest req){
        Boolean checkEmail = RegularUtils.checkEmail(email);
        if(!checkEmail){
            return R.error("邮箱不符合格式");
        }
        // 获得session
        HttpSession session = req.getSession();
        String session_code = (String) session.getAttribute(email+"code");
        log.info("session code: " + session_code);
        log.info("code: " + code);
        if(code==null || !code.equals(session_code)){
            return R.error("验证码不正确");
        }
        Map<String, String> params = new HashMap();
        params.put("access_token","_bl_uid");
        params.put("expires_in","_bl_uid");
        params.put("refresh_token","_bl_uid");
        params.put("redirectUrl","_bl_uid");
        return R.success(params);
    }
}