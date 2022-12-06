package com.example.videos.service;

import com.example.videos.dao.UserDao;
import com.example.videos.dao.imp.UserDaoImp;
import com.example.videos.entity.User;
import com.example.videos.utils.StringUtils;

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
}
