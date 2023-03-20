package xyz._007666.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import xyz._007666.mybatis.entity.User;

@Mapper
public interface CurdMapper {
    User getUserById(int id);

    boolean insertUser(User user);

    boolean updateUser(User user);

    boolean deleteUser(int id);
}
