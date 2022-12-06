package com.example.videos.service;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.videos.dao.UserDao;
import com.example.videos.dao.imp.UserDaoImp;
import com.example.videos.entity.User;
import com.example.videos.utils.StringUtils;
import com.example.videos.utils.TimeUtil;
import com.example.videos.utils.TokenUtils;

import java.util.HashMap;
import java.util.Map;

public class UserServiceImp implements UserService {
    private final UserDao userDao = new UserDaoImp();
    /**
     * @param user
     * @return
     */
    @Override
    public Boolean saveUser(User user) {
        Integer row = userDao.insertUser(user);
        return row != 0;
    }

    /**
     * 通过邮箱和密码查找用户
     * @param email
     * @param password
     * @return
     */
    @Override
    public User getUserByEmailAndPassword(String email, String password) {
        User user = userDao.findByEmailAndPassword(email, password);
        return user;
    }

    /**
     * 根据邮箱查找用户
     *
     * @param email
     */
    @Override
    public User getUserByEmail(String email) {
        User user = userDao.getUserByEmail(email);
        if (user != null){
            return user;
        }
        return null;
    }


    /**
     * @param email
     * @param password
     * @return
     */
    @Override
    public User login(String email, String password) {
        // 获得数据库里被加密的密码
        String encryptionPasswd = userDao.getUserPasswordByEmail(email);
        // 验证两个密码是否一致
        Boolean result = StringUtils.verifyPassword(password,encryptionPasswd);
        if (result){
            User user = userDao.getUserByEmail(email);
            return user;
        }
        return null;
    }

    /**
     * @param token
     * @return
     */
    @Override
    public Map<String, Object> createTokenMap(String token) {
        Boolean result = TokenUtils.verify(token);
        if (result){
            DecodedJWT tokenJwt = TokenUtils.convert_token(token);
            String email = tokenJwt.getClaim("email").toString();
            String new_token = TokenUtils.token(email);
            String new_refresh_token = TokenUtils.refresh_token(email);
            Map<String, Object> params = new HashMap();
            params.put("access_token",new_token);
            // 过期时间
            params.put("expires_in", TimeUtil.getTokenExpression());
            params.put("refresh_token",new_refresh_token);
            params.put("redirectUrl","还木有哦");
            return params;
        }
        return null;
    }

    /**
     * @param refresh_token
     * @return
     */
    @Override
    public Map<String, Object> createreRreshTokenMap(String refresh_token) {
        Boolean result = TokenUtils.verify_refresh(refresh_token);
        if (result){
            DecodedJWT tokenJwt = TokenUtils.convert_refresh_token(refresh_token);
            String email = tokenJwt.getClaim("email").toString();
            String new_token = TokenUtils.token(email);
            String new_refresh_token = TokenUtils.refresh_token(email);
            Map<String, Object> params = new HashMap();
            params.put("access_token",new_token);
            // 过期时间
            params.put("expires_in", TimeUtil.getTokenExpression());
            params.put("refresh_token",new_refresh_token);
            params.put("redirectUrl","还木有哦");
            return params;
        }
        return null;
    }

    /**
     * 根据token获取用户信息
     *
     * @param token
     */
    @Override
    public User getUserByToken(String token) {
        Boolean result = TokenUtils.verify(token);
        if (result){
            DecodedJWT tokenJwt = TokenUtils.convert_token(token);
            String email = tokenJwt.getClaim("email").asString();
            User user = userDao.getUserByEmail(email);
            return user;
        }
        return null;
    }
}
