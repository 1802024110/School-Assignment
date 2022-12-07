package com.example.videos.mapper;

import com.example.videos.entity.UserVideoLike;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VideoLikeMapper implements RowMapper<UserVideoLike> {
    @Override
    public UserVideoLike mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserVideoLike userVideoLike = new UserVideoLike();
        userVideoLike.setId(rs.getLong("id"));
        userVideoLike.setUpdateTime(rs.getTimestamp("update_time"));
        userVideoLike.setDeleted(rs.getBoolean("is_deleted"));
        userVideoLike.setIp(rs.getString("ip"));
        userVideoLike.setVideoId(rs.getLong("video_id"));
        userVideoLike.setUserId(rs.getLong("user_id"));
        return userVideoLike;
    }
}
