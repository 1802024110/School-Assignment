package com.example.videos.controller;

import com.alibaba.druid.util.StringUtils;
import com.example.videos.common.R;
import com.example.videos.dao.UserDao;
import com.example.videos.dao.imp.UserDaoImp;
import com.example.videos.entity.User;
import com.example.videos.utils.EmailUtils;
import com.example.videos.utils.ValidateCodeUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;

@Path("public")
public class PublicController {
    private final UserDao userDao = new UserDaoImp();
    @GET
    @Path("getCode/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public R<String> getCode(@PathParam("email") String email, @Context HttpServletRequest req) {
        if (!StringUtils.isEmpty(email)) {
            // 生成验证码
            String code = ValidateCodeUtils.generateValidateCode4String(4);
            // 获得session
            HttpSession session = req.getSession();
            // 设置code到session
            session.setAttribute(email + "code", code);
            // 发送邮件
            boolean success = EmailUtils.sendSimpleMessage(email, "梦无念验证码", "您的验证码为: " + code);
            if (success) {
                return R.success(null, "验证码发送成功");
            }
        }
        return R.error("未知错误,验证码发送失败");
    }
    @GET
    @Path("checkEmail/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public R<String> checkEmail(@PathParam("email") String email){
        User user = userDao.getUserByEmail(email);
        if (user == null) {
            return R.success(null,"邮箱可用");
        }
        return R.error("邮箱已被使用");
    }
}
