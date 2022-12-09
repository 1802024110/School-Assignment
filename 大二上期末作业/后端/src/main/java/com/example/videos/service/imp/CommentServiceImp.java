package com.example.videos.service.imp;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.videos.dao.CommentDao;
import com.example.videos.dao.UserDao;
import com.example.videos.dao.imp.CommentDaoImp;
import com.example.videos.dao.imp.UserDaoImp;
import com.example.videos.entity.Comment;
import com.example.videos.service.CommentService;
import com.example.videos.utils.TokenUtils;

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
    public Boolean sendComment(String token, String commentText, String videoId, long parentId) {
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
        Integer row = commentDao.insetComment(comment);
        return row != 0 ? true : false;
    }
}
