package com.example.videos.service;

import com.example.videos.dao.UserDao;
import com.example.videos.dao.imp.UserDaoImp;
import com.example.videos.entity.User;

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
}
