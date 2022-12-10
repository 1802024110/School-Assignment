package com.example.videos.dao;

import com.example.videos.entity.Comment;

public interface CommentDao {
    Integer insetComment(Comment comment);
    Integer deleteComment(String commentId, Integer userId);

    Integer likeComment(Integer userId, String id);
}
