package com.example.videos.dao.imp;

import com.example.videos.dao.VideoDao;
import com.example.videos.entity.User;
import com.example.videos.entity.Video;
import com.example.videos.mapper.VideoRowMapper;
import com.example.videos.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class VideoDaoImp implements VideoDao {
    private final JdbcTemplate jdbc = new JdbcTemplate(JDBCUtils.getDataSource());


    /**
     * 根据视频id获得视频
     *
     * @param id
     */
    @Override
    public Video getVideoById(Integer id) {
        String sql = "SELECT id,update_time,`status`,title,cover,is_top,upload_user,`describe`,video_style,play_url FROM video WHERE id = ?";
        Video video = jdbc.queryForObject(sql,new VideoRowMapper(),id);
        return video;
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
    public List<Video> getStyleVideos(List<Integer> video_style, Integer page) {
        List<Integer> videoStyles = Arrays.asList(1, 2, 3, 4, 5);

        String sql = "SELECT * FROM video WHERE video_style IN (?) LIMIT 10 OFFSET ?";


        // 将类似数组转为字符串
        String styleStr = videoStyles.stream()
                .map(Object::toString)
                .collect(Collectors.joining(","));
        List<Video> videos = jdbc.query(sql, new VideoRowMapper(),styleStr,0);
        System.out.println(videos);
        return videos;
}

    /**
     * @param styles
     * @return
     */
    @Override
    public Integer getVideoCountByStyles(List<Integer> styles) {
        String sql = "SELECT count(id) FROM video WHERE video_style IN (?)";

        // 将类似数组转为字符串
        String styleStr = styles.stream()
                .map(Object::toString)
                .collect(Collectors.joining(","));

        Integer videoCount = jdbc.queryForObject(sql,Integer.class,styleStr);

        return videoCount;
    }
}
