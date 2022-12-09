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
        String sql = "INSERT INTO comments ( user_id, content, is_deleted, video_id, likes, parent_id)\n" +
                "VALUES ( :userid,:comment, :is_delete, :video_id, :like, :parent_id)";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("userid",comment.getUserId());
        parameterSource.addValue("comment",comment.getContent());
        parameterSource.addValue("is_delete",comment.getIsDeleted());
        parameterSource.addValue("video_id",comment.getVideoId());
        parameterSource.addValue("like",comment.getLikes());
        parameterSource.addValue("parent_id",comment.getParentId());
        Integer row = namedParameterJdbcTemplate.update(sql,parameterSource);
        return row;
    }
}
