package com.example.videos.service;

import com.example.videos.dao.UserDao;
import com.example.videos.dao.imp.UserDaoImp;
import com.example.videos.entity.User;
import com.example.videos.utils.StringUtils;
import com.example.videos.utils.TimeUtil;
import com.example.videos.utils.TokenUtils;

import java.util.HashMap;
import java.util.Map;

public class UserServiceImp implements UserService {
    private UserDao userDao = new UserDaoImp();
    /**
     * @param user
     * @return
     */
    @Override
    public Boolean saveUser(User user) {
        Integer row = userDao.insertUser(user);
        if (row != 0) {
            return true;
        }
        return false;
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
     * @param email
     * @param token
     * @param refreshToken
     * @return
     */
    @Override
    public Boolean updateTokenAndRefreshTokenByEmail(String email, String token, String refreshToken) {
        Integer row =  userDao.updateTokenAndRefreshTokenByEmail(email, token,refreshToken);
        if (row != 0) {
            return true;
        }else {
            return false;
        }
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
     * 刷新token
     * @param refreshToken
     */
    @Override
    public Map<String, String> refreshToken(String refreshToken) {
        User user = userDao.getUserByRefreshToken(refreshToken);
        if (user != null){
            String newToken = TokenUtils.token(user.getEmail(),user.getPassword());
            String newRefreshToken = TokenUtils.refresh_token();
            Integer row = userDao.updateTokenAndRefreshTokenByEmail(user.getEmail(),newToken,newRefreshToken);
            if (row != null){
                Map<String,String> data = new HashMap();
                data.put("token",newToken);
                data.put("refresh_token",newRefreshToken);
                data.put("expires_in",TimeUtil.getTokenExpression());
                return data;
            }
        }
        return null;
    }
}
