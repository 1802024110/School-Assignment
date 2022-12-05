package com.example.videos.dao.imp;

import com.example.videos.dao.UserDao;
import com.example.videos.entity.User;
import com.example.videos.utils.JDBCUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImp implements UserDao {
    private final JdbcTemplate jdbc = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 添加用户
     *
     * @param user
     */
    @Override
    public void add(User user) {

    }

    /**
     * 根据token查找用户
     *
     * @param token
     */
    @Override
    public User getUserByToken(String token) {
        String  sql = "select * from user where token = ?";
        User user = jdbc.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),token);
        return user;
    }

    /**
     * 根据email查找用户
     * @param email
     */
    @Override
    public User getUserByEmail(String email) {
        String  sql = "select * from user where email = ?";
       try{
           User user = jdbc.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),email);
           return user;
           // 捕获为空的异常
       }catch (EmptyResultDataAccessException e){
           // 为空就返回null
           return null;
       }
    }
}
