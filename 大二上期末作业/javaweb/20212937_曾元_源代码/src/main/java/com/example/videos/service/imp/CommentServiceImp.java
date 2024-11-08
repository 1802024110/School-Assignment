package com.example.videos.service.imp;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.videos.dao.CommentDao;
import com.example.videos.dao.UserDao;
import com.example.videos.dao.imp.CommentDaoImp;
import com.example.videos.dao.imp.UserDaoImp;
import com.example.videos.entity.Comment;
import com.example.videos.mapper.CommentsRowMapper;
import com.example.videos.service.CommentService;
import com.example.videos.utils.RequestUtil;
import com.example.videos.utils.TokenUtils;
import jakarta.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommentServiceImp implements CommentService {
    private final UserDao userDao = new UserDaoImp();
    private final CommentDao commentDao = new CommentDaoImp();
    /**
     * 发送评论API
     *
     * @param token
     * @param commentText
     * @param videoId
     * @param parentId
     */
    @Override
    public Boolean sendComment(String token, String commentText, String videoId, long parentId,String ip) {
        DecodedJWT tokenJwt = TokenUtils.convert_token(token);
        String email = tokenJwt.getClaim("email").asString();
        // 获得当前用户的id
        Integer userId = userDao.getUserIdByEmail(email);

        // 创建一个新的评论对象
        Comment comment = new Comment();
        comment.setUserId(userId);
        comment.setContent(commentText);
        comment.setIsDeleted(0);
        comment.setVideoId(videoId);
        comment.setLikes(0);
        comment.setParentId(parentId);
        comment.setIp(ip);
        Integer row = commentDao.insetComment(comment);
        return row != 0 ? true : false;
    }

    /**
     * @param token
     * @param id
     * @return
     */
    @Override
    public Boolean deleteComment(String token, String id) {
        DecodedJWT tokenJwt = TokenUtils.convert_token(token);
        String email = tokenJwt.getClaim("email").asString();
        // 获得当前用户的id
        Integer userId = userDao.getUserIdByEmail(email);
        Integer row = commentDao.deleteComment(id, userId);
        return row != 0 ? true : false;
    }

    /**
     * @param token
     * @param id
     * @return
     */
    @Override
    public Boolean likeComment(String token, String id) {
        DecodedJWT tokenJwt = TokenUtils.convert_token(token);
        String email = tokenJwt.getClaim("email").asString();
        // 获得当前用户的id
        Integer userId = userDao.getUserIdByEmail(email);
        Integer row = commentDao.likeComment(userId,id);
        return row != 0? true : false;
    }

    /**
     * @param token
     * @param id
     * @return
     */
    @Override
    public Boolean removeLikeComment(String token, String id) {
        DecodedJWT tokenJwt = TokenUtils.convert_token(token);
        String email = tokenJwt.getClaim("email").asString();
        // 获得当前用户的id
        Integer userId = userDao.getUserIdByEmail(email);
        Integer row = commentDao.removeLikeComment(userId,id);
        return row!=0? true : false;
    }

    /**
     * @param videoId
     * @return
     */
    @Override
    public Map<String, Object> queryVideoComments(Integer videoId, Integer page) {
        List<Comment> comments = commentDao.queryVideoComments(videoId,page);
        Integer count = commentDao.getVideoCommentsCount(videoId);
        Map<String, Object> params = new HashMap();
        params.put("videoId", videoId);
        params.put("total", count);
        params.put("limit", count!=0?count/10-1:0);
        params.put("comments", comments);
        return params;
    }
}
