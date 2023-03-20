package xyz._007666.mybatis.mapper;

import org.apache.ibatis.annotations.*;
import xyz._007666.mybatis.entity.Address;
import xyz._007666.mybatis.entity.Comment;
import xyz._007666.mybatis.entity.User;
import xyz._007666.mybatis.provider.NoteSqlProvider;

import java.util.List;

@Mapper
@CacheNamespace
public interface NoteMapper {
    @Select("select * from user where id = #{id}")
    @Results(id = "userInfoMap",value = {
            @Result(property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "gender",column = "gender"),
            @Result(property = "phone",column = "phone"),
            @Result(property = "comments",many = @Many(select = "getCommentsByUserId"),column = "id"),
            @Result(property = "address",one = @One(select = "getAddressByUserId"),column = "id")
    })
    User getUserById(Integer id);

    @Select("select * from comment where user_id=#{userId}")
    @Results(id = "commentsMap",value = {
            @Result(property = "id",column = "id"),
            @Result(property = "userId",column = "user_id"),
            @Result(property = "commentText",column = "comment_text"),
    })
    List<Comment> getCommentsByUserId(Integer userId);

    @Select("select * from address where user_id=#{userId}")
    Address getAddressByUserId(Integer id);

    @ResultMap("userInfoMap")
    @SelectProvider(type = NoteSqlProvider.class,method = "getUserByName")
    List<User> getUsersByName(String name);
}
