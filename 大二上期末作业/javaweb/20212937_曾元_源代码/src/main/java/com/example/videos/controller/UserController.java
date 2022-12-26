package com.example.videos.controller;

import com.example.videos.common.R;
import com.example.videos.entity.User;
import com.example.videos.entity.Video;
import com.example.videos.note.AuthCheck;
import com.example.videos.service.PublicService;
import com.example.videos.service.UserService;
import com.example.videos.service.imp.PublicServiceImp;
import com.example.videos.service.imp.UserServiceImp;
import com.example.videos.utils.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户Api
 * 参考文章: https://www.bloghome.com.cn/post/jersey-kai-fa-restful-ba-jerseycan-shu-bang-ding.html
 * */
@Path("user")
@Slf4j
@Produces(MediaType.APPLICATION_JSON)
public class UserController {
    private final UserService userService = new UserServiceImp();
    private final PublicService publicService = new PublicServiceImp();


    /**
     * 注册
    * */
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
        Boolean checkCode = publicService.checkCodeByEmail(code,email);

        if(!checkCode){
            return R.error("验证码不正确");
        }

        // 创建新用户对象
        User user = new User();
        user.setEmail(email);
        user.setUsername(userName);
        password = StringUtils.encryptionPasswd(password);
        user.setPassword(password);
        user.setIp(RequestUtil.getIP(req));
        String token = TokenUtils.token(email);

        // 保存用户
        if (userService.saveUser(user)){
            Map<String,Object> params = userService.createTokenMap(token);
            return R.success(params);
        }
        return R.error("注册失败");
    }
    /**
     * 登录
     * */
    @POST
    @Path("oauth/access_token")
    public R<Map<String,Object>> login(
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
            // 生成token和refresh_token
            String token = TokenUtils.token(email);
            String refresh_token = TokenUtils.refresh_token(email);
            Map<String, Object> params = new HashMap();
            params.put("access_token",token);
            // 过期时间
            params.put("expires_in", TimeUtil.getTokenExpression());
            params.put("refresh_token",refresh_token);
            params.put("redirectUrl","还木有哦");
            return R.success(params);
        }
        return R.error("用户名或密码错误");
    }

    /**
    * 刷新令牌
    * */
    @PUT
    @Path("/oauth/refresh_token")
    public R<Map> refreshToken(
            @FormParam("refresh_token") String refresh_token
    ) {
        Boolean checkToken = TokenUtils.verify_refresh(refresh_token);

        if(checkToken){
            Map<String, Object> params = userService.createreRreshTokenMap(refresh_token);
            return R.success(params);
        }
        return R.error("刷新失败");
    }

    @GET
    @Path("info")
    @AuthCheck
    public R<Map> getMyInfo(@Context HttpServletRequest request){
        return getUserInfo(request,"");
    }

    /**
     * 获得用户的所有基本信息
     * */
    @GET
    @Path("info/{id}")
    @AuthCheck
    public R<Map> getUserInfo(@Context HttpServletRequest request,@PathParam("id") String id){
        String token = request.getHeader("Authorization");
        User user = userService.getUserByToken(token,id);
        if (user != null){
            return R.success(user.getPublicInfo(),"用户信息获取成功");
        }
        return R.error("用户信息获取失败");
    }

    /**
     * 获取用户投稿的视频
     * */
    @GET
    @Path("contribute")
    @AuthCheck
    public R<List<Video>> getSubmitVideos(@Context HttpServletRequest request){
        String token = request.getHeader("Authorization");
        List<Video> videos = userService.getUserSubmitVideos(token);
        return R.success(videos);
    }
    @GET
    @Path("likeVideo")
    @AuthCheck
    public R<List<Video>> getLikeVideos(@Context HttpServletRequest request){
        String token = request.getHeader("Authorization");
        List<Video> videos = userService.getUserLikeVideos(token);
        return R.success(videos);
    }
}