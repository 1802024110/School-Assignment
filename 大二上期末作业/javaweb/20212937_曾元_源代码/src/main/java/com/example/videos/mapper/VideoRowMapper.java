package com.example.videos.mapper;

import com.example.videos.entity.Video;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VideoRowMapper implements RowMapper<Video> {
    /**
     * @param rs
     * @param rowNum
     * @return
     * @throws SQLException
     */
    @Override
    public Video mapRow(ResultSet rs, int rowNum) throws SQLException {
        Video video = new Video();
        video.setId(rs.getLong("id"));
        video.setUpdateTime(rs.getTimestamp("update_time"));
        video.setStatus(rs.getString("status"));
        video.setTitle(rs.getString("title"));
        video.setCover(rs.getString("cover"));
        video.setTop(rs.getBoolean("is_top"));
        video.setUploadUser(rs.getInt("upload_user"));
        video.setDescribe(rs.getString("describe"));
        video.setVideoStyle(rs.getString("video_style"));
        video.setPlayUrl(rs.getString("play_url"));
        return video;
    }
}
