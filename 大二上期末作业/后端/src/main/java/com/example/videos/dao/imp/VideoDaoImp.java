package com.example.videos.dao.imp;

import com.example.videos.dao.VideoDao;
import com.example.videos.entity.User;
import com.example.videos.utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class VideoDaoImp implements VideoDao {
    private final JdbcTemplate jdbc = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 用户投稿的视频id
     *
     * @param user
     */
    @Override
    public List<Integer> getUserVideosId(User user) {
        String sql = "SELECT video_id FROM video_ownership WHERE user_id=?";
        List<Integer> ids =  jdbc.queryForList(sql,Integer.class,user.getId());
        return ids;
    }

    /**
     * 用户喜欢的视频id
     *
     * @param user
     */
    @Override
    public List<Integer> getLikeVideosId(User user) {
        String sql = "SELECT video_id FROM video_like WHERE like_user=?";
        List<Integer> ids =  jdbc.queryForList(sql,Integer.class,user.getId());
        return ids;
    }
}
