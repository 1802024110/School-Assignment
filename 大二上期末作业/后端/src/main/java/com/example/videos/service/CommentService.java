package com.example.videos.service;

import com.example.videos.mapper.CommentsRowMapper;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.Map;

public interface CommentService {
    /**
     * 发送评论API
     * */

    Boolean sendComment(String token, String commentText, String videoId, long parentId,String ip);

    Boolean deleteComment(String token, String id);

    Boolean likeComment(String token, String id);

    Boolean removeLikeComment(String token, String id);

    Map<String, Object> queryVideoComments(Integer videoId,Integer page);
}
