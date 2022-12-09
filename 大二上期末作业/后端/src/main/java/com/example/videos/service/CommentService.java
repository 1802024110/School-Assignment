package com.example.videos.service;

public interface CommentService {
    /**
     * 发送评论API
     * */

    Boolean sendComment(String token, String commentText, String videoId, long parentId);
}
