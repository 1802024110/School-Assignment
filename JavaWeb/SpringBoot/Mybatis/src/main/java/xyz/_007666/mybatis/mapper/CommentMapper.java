package xyz._007666.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import xyz._007666.mybatis.entity.Comment;

@Mapper
public interface CommentMapper {
    Comment getCommentByUserId(String userId);
}
