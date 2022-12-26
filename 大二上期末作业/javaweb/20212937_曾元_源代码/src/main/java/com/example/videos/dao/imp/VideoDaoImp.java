package com.example.videos.dao.imp;

import com.example.videos.dao.VideoDao;
import com.example.videos.entity.User;
import com.example.videos.entity.Video;
import com.example.videos.mapper.VideoRowMapper;
import com.example.videos.utils.JDBCUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class VideoDaoImp implements VideoDao {
    // 错误的用法，没有防sql注入
    private final JdbcTemplate jdbc = new JdbcTemplate(JDBCUtils.getDataSource());
    // 创建一个 NamedParameterJdbcTemplate 来执行查询，可以防sql注入
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbc);

    /**
     * 根据视频id获得视频
     *
     * @param id
     */
    @Override
    public Video getVideoById(Integer id) {
        try {

            String sql = "SELECT id,update_time,`status`,title,cover,is_top,upload_user,`describe`,video_style,play_url FROM video WHERE id = ?";
            Video video = jdbc.queryForObject(sql,new VideoRowMapper(),id);
            return video;
        } catch (EmptyResultDataAccessException e) {
            return  null;
        }
    }

    /**
     * @param keyword
     * @param page
     * @return
     */
    @Override
    public List<Video> getVideoByKey(String keyword, Integer page) {
        String sql = "SELECT *\n" +
                "FROM video\n" +
                "WHERE title LIKE ?\n" +
                "LIMIT 10 OFFSET ?";
        // 将keyword中的?进行双重转义
        keyword = keyword.replace("?", "\\?");
        // 查询 title 中包含 keyword 的前 10 条记录
        List<Video> videos = jdbc.query(sql, new VideoRowMapper(), "%" + keyword + "%", page*10);
        return videos;
    }

    /**
     * @param keyword
     * @return
     */
    @Override
    public Integer getVideoCountByKey(String keyword) {
        String sql = "SELECT COUNT(id) FROM video WHERE title LIKE ?";
        keyword = keyword.replace("?", "\\?");
        Integer videoCount = jdbc.queryForObject(sql,Integer.class, "%"+keyword+"%");
        return videoCount;
    }

    /**
     * @param userId
     * @return
     */
    @Override
    public List<Integer> getUserLikeStyles(Integer userId) {
        String sql = "SELECT video_id FROM user_video_like WHERE user_id = ?";
        List<Integer> likeStyles = jdbc.queryForList(sql,Integer.class,userId);
        return likeStyles;
    }

    /**
     * @param video_style
     * @param page
     * @return
     */
    @Override
    // 根据指定的样式和页码获取视频列表
    public List<Video> getStyleVideos(List<Integer> video_style, Integer page) {
        // 创建要执行的 SQL 查询语句
        String sql = "SELECT * FROM video WHERE video_style IN (:styleStyle) LIMIT 10 OFFSET :page";

        // 创建一个 MapSqlParameterSource 来保存查询参数值
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("styleStyle",video_style);
        parameterSource.addValue("page",page*10);

        // 执行查询，将结果集映射到 Video 对象列表
        List<Video> videos = namedParameterJdbcTemplate.query(sql,parameterSource,new VideoRowMapper());

        // 返回视频列表
        return videos;
    }


    /**
     * @param styles
     * @return
     */
    @Override
    public Integer getVideoCountByStyles(List<Integer> styles) {
        String sql = "SELECT count(id) FROM video WHERE video_style IN (:styles)";

        // 创建一个 MapSqlParameterSource 来保存查询参数值
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("styles",styles);

        Integer videoCount = namedParameterJdbcTemplate.queryForObject(sql,parameterSource,Integer.class);

        return videoCount;
    }

    /**
     * @return
     */
    @Override
    public List<Video> getRandomVideos() {
        // 使用 SQL 语句获取结果
        String sql = "SELECT * FROM video WHERE status = '正常' ORDER BY RAND() LIMIT 10";
        // 将结果封装为 Video 对象的 List 集合
        List<Video> videos = namedParameterJdbcTemplate.query(sql,new VideoRowMapper());
        // 返回视频列表
        return videos;
    }

    /**
     * 根据视频id获得上传者(作者信息)
     *
     * @param id
     */
    @Override
    public User getUserByVideoID(Integer id) {
        String sql = "SELECT user.* FROM user,video WHERE user.id=video.upload_user AND video.id = :video_id";
        // 创建一个 MapSqlParameterSource 来保存查询参数值
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("video_id",id);
        User user = namedParameterJdbcTemplate.queryForObject(sql,parameterSource, new BeanPropertyRowMapper<User>(User.class));
        return user;
    }

}
