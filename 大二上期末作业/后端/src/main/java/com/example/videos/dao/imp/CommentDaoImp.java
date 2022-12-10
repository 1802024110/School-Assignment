package com.example.videos.dao.imp;

import com.example.videos.dao.CommentDao;
import com.example.videos.entity.Comment;
import com.example.videos.utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class CommentDaoImp implements CommentDao {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(new JdbcTemplate(JDBCUtils.getDataSource()));
    /**
     * @param comment
     * @return
     */
    @Override
    public Integer insetComment(Comment comment) {
        String sql = "INSERT INTO comments ( user_id, content, is_deleted, video_id, likes, parent_id,ip)\n" +
                "VALUES ( :userid,:comment, :is_delete, :video_id, :like, :parent_id,:ip)";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("userid",comment.getUserId());
        parameterSource.addValue("comment",comment.getContent());
        parameterSource.addValue("is_delete",comment.getIsDeleted());
        parameterSource.addValue("video_id",comment.getVideoId());
        parameterSource.addValue("like",comment.getLikes());
        parameterSource.addValue("parent_id",comment.getParentId());
        parameterSource.addValue("ip",comment.getIp());
        Integer row = namedParameterJdbcTemplate.update(sql,parameterSource);
        return row;
    }

    /**
     * @param commentId
     * @param userId
     * @return
     */
    @Override
    public Integer deleteComment(String commentId, Integer userId) {
        String sql = "DELETE FROM comments\n" +
                "WHERE id = :commentId AND user_id = :user_id";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("commentId",commentId);
        parameterSource.addValue("user_id",userId);
        Integer row = namedParameterJdbcTemplate.update(sql,parameterSource);
        return row;
    }

    /**
     * 同步评论表和评论点赞表
     * */
    private Boolean syncComment(Integer userId,String commentId){
        String sql = "INSERT INTO comments_likes (comment_id, user_id, ip)\n" +
                "SELECT comments.id, comments.user_id,  comments.ip\n" +
                "FROM comments\n" +
                "LEFT JOIN comments_likes ON comments.id = comments_likes.comment_id\n" +
                "WHERE comments_likes.comment_id IS NULL AND comments.user_id = :userId AND comments.id= :commentId";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("userId",userId);
        parameterSource.addValue("commentId",commentId);
        Integer row = namedParameterJdbcTemplate.update(sql,parameterSource);
        return row != 0?true : false;
    }

    /**
     * @param userId
     * @param id
     * @return
     */
    @Override
    public Integer likeComment(Integer userId, String id) {
        String sql = "UPDATE comments\n" +
                "SET likes = likes + 1\n" +
                "WHERE id NOT IN (SELECT comment_id FROM comments_likes) and user_id=:userId and id = :commentId";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("userId",userId);
        parameterSource.addValue("commentId",id);
        Integer row = namedParameterJdbcTemplate.update(sql,parameterSource);
        this.syncComment(userId,id);
        return row;
    }
}
