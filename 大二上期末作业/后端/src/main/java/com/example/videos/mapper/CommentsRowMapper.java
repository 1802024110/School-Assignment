package com.example.videos.mapper;

import com.example.videos.entity.Comment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentsRowMapper implements RowMapper<Comment> {
    /**
     * @param rs
     * @param rowNum
     * @return
     * @throws SQLException
     */
    @Override
    public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
        Comment comment = new Comment();
        comment.setId(rs.getLong("id"));
        comment.setUserId(rs.getLong("user_id"));
        comment.setContent(rs.getString("content"));
        comment.setUpdatedAt(rs.getTimestamp("updated_at"));
        comment.setIsDeleted(rs.getLong("is_deleted"));
        comment.setVideoId(rs.getString("video_id"));
        comment.setLikes(rs.getLong("likes"));
        comment.setParentId(rs.getLong("parent_id"));
        comment.setTargetCommentId(rs.getLong("target_comment_id"));
        return comment;
    }
}
