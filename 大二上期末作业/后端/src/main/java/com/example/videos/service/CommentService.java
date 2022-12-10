package com.example.videos.service;

import jakarta.servlet.http.HttpServletRequest;

public interface CommentService {
    /**
     * 发送评论API
     * */

    Boolean sendComment(String token, String commentText, String videoId, long parentId,String ip);

    Boolean deleteComment(String token, String id);

    Boolean likeComment(String token, String id);

    Boolean removeLikeComment(String token, String id);
}
