package xyz._007666.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import xyz._007666.mybatis.entity.User;

@Mapper
public interface LabelMapper {
    User sqlTemplate();

    User singleParameterType(int id);

    @Select("select * from user where user.${columnName}=#{columnValue}")
    User findByColumn(String columnName, String columnValue);

    User myResultMap();

    User selectUserAddress(int id);
}
