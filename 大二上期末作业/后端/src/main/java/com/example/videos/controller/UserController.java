package com.example.videos.controller;

import com.example.videos.common.R;
import com.example.videos.dao.UserDao;
import com.example.videos.dao.imp.UserDaoImp;
import com.example.videos.entity.User;
import com.example.videos.note.UserLogger;
import com.example.videos.service.UserService;
import com.example.videos.service.UserServiceImp;
import com.example.videos.utils.*;
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
    private UserService userService = new UserServiceImp();

    @POST
    @Path("register")
    public R<Map> register(
            @FormParam("email") String email,
            @FormParam("password") String password,
            @FormParam("code") String code,
            @FormParam("userName") String userName,
            @Context HttpServletRequest req){
       // 检查邮箱
        Boolean checkEmail = RegularUtils.checkEmail(email);
        if(!checkEmail){
            return R.error("邮箱不符合格式");
        }

        // 检查验证码
        HttpSession session = req.getSession();
        String session_code = (String) session.getAttribute(email+"code");
        if(code==null || !code.equals(session_code)){
            return R.error("验证码不正确");
        }

        // 创建新用户对象
        User user = new User();
        user.setEmail(email);
        user.setUsername(userName);
        password = StringUtils.encryptionPasswd(password);
        user.setPassword(password);
        user.setIp(RequestUtil.getIP(req));
        String token = TokenUtils.token(email,password);
        String refresh_token = TokenUtils.refresh_token();
        user.setToken(token);
        user.setRefresh_token(refresh_token);

        // 保存用户
        if (userService.saveUser(user)){

            // 生成返回体
            Map<String, String> params = new HashMap();
            params.put("access_token",token);
            // 过期时间
            String expires_in = TimeUtil.MillisecondsToDate(System.currentTimeMillis() + 60000 * 60 * 2);
            params.put("expires_in", expires_in);
            params.put("refresh_token",refresh_token);
            params.put("redirectUrl","还木有哦");
            return R.success(params);
        }
        return R.error("注册失败");
    }
    @POST
    @Path("oauth/access_token")
    public R<Map<String,String>> login(
            @FormParam("email") String email,
            @FormParam("password") String password
    ){
        // 检查邮箱和密码格式
        Boolean checkEmail = RegularUtils.checkEmail(email);
        Boolean checkPassword = RegularUtils.checkPassword(password);
        if(!checkEmail || !checkPassword){
            return R.error("邮箱或密码不符合格式");
        }

        User user =  userService.login(email, password);

        if(user != null){
            // 生成新的token和refresh_token
            String token = TokenUtils.token(email, password);
            String refresh_token = TokenUtils.refresh_token();
            user.setToken(token);
            user.setRefresh_token(refresh_token);

            // 保存新的token和refresh_token
            Boolean update = userService.updateTokenAndRefreshTokenByEmail(email,token,refresh_token);

            // 更新成功
            if (update) {
                Map<String, String> params = new HashMap();
                params.put("access_token",token);
                // 过期时间
                String expires_in = TimeUtil.MillisecondsToDate(System.currentTimeMillis() + 60000 * 60 * 2);
                params.put("expires_in", expires_in);
                params.put("refresh_token",refresh_token);
                params.put("redirectUrl","还木有哦");
                return R.success(params);
            }
        }
        return R.error("用户名或密码错误");
    }

}