package com.example.videos.dao.imp;

import com.example.videos.dao.UserDao;
import com.example.videos.entity.User;
import com.example.videos.entity.Video;
import com.example.videos.mapper.VideoRowMapper;
import com.example.videos.utils.JDBCUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 用户的数据库实现
 * 参考文章: https://www.cnblogs.com/gongxr/p/8053010.html
 * */
@Slf4j
public class UserDaoImp implements UserDao {
    private final JdbcTemplate jdbc = new JdbcTemplate(JDBCUtils.getDataSource());
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbc);

    /**
     * 添加用户
     *
     * @param user
     */
    @Override
    public void add(User user) {

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

    /**
     * @param user 用户实体
     */
    @Override
    public Integer insertUser(User user) {
        String  sql = "INSERT INTO user(`silence`, `username`, `password`, `email`, `gender`, `avatar`, `sign`, `level`, `birthday`, `country`, `ip`, `focus_count`, `like_count`, `fans_count`, `background_img`, `tel`) \n" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?)";
        try{
            Integer row = jdbc.update(sql,user.getSilence(),user.getUsername(),user.getPassword(),user.getEmail(),user.getGender(),user.getAvatar(),user.getSign(),user.getLevel(),user.getBirthday(),user.getCountry(),user.getIp(),user.getFocusCount(),user.getLikeCount(),user.getFansCount(),user.getBackgroundImg(),user.getTel());
            return row;
            // 已经存在邮箱的情况下会有数据完整性报错，表示已经存在该邮箱或手机号。
        }catch (DataIntegrityViolationException e){
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * @param email
     * @param password
     * @return
     */
    @Override
    public User findByEmailAndPassword(String email, String password) {
        log.info("邮箱是："+email);
        log.info("密码是："+password);
        String  sql = "select * from user where email = ? and password = ? where silence=0";
        try{
            User user = jdbc.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),email,password);
            return user;
            // 捕获为空的异常
        }catch (EmptyResultDataAccessException e){
            // 为空就返回null
            return null;
        }
    }
    /**
     * @param email
     * @return
     */
    @Override
    public String getUserPasswordByEmail(String email) {
        try{
        String sql = "select * from user where email = ?";
        User user = jdbc.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),email);
        String encryptionPasswd = user.getPassword();
        return encryptionPasswd;
            // 捕获为空的异常
        }catch (EmptyResultDataAccessException e){
            // 为空就返回null
            return "";
        }
    }

    /**
     * @param email
     * @return
     */
    @Override
    public Integer getUserIdByEmail(String email) {
        try {
            String sql = "select id from user where email = ?";
            Integer userId = jdbc.queryForObject(sql,Integer.class,email);
            return userId;
        }
        // 捕获返回为空的情况
        catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<Video> getSubmitVideosByUserId(Integer userId) {
        String sql = "SELECT * FROM video WHERE upload_user=?";
        List<Video> videos = jdbc.query(sql,new VideoRowMapper(),userId);;
        return videos;
    }

    /**
     * @param userId
     * @return
     */
    @Override
    public List<Integer> getLikeVideosByUserId(Integer userId) {
        String sql = "SELECT video_id\n" +
                "FROM user_video_like\n" +
                "WHERE video_id IN (SELECT id FROM video) AND user_id=?";
        List<Integer> videos = jdbc.queryForList(sql,Integer.class,userId);
        return videos;
    }
}
