package com.example.videos.dao;

import com.example.videos.entity.Comment;
import com.example.videos.mapper.CommentsRowMapper;

import java.util.List;

public interface CommentDao {
    Integer insetComment(Comment comment);
    Integer deleteComment(String commentId, Integer userId);

    Integer likeComment(Integer userId, String id);

    Integer removeLikeComment(Integer userId, String id);

    List<Comment> queryVideoComments(Integer videoId,Integer page);

    Integer getVideoCommentsCount(Integer videoId);
}
