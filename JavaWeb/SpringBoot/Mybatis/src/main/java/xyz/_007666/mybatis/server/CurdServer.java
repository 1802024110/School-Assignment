package xyz._007666.mybatis.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz._007666.mybatis.entity.User;
import xyz._007666.mybatis.mapper.CurdMapper;

public interface CurdServer {
    User getUserById(int id);

    boolean saveUser(User user);

    boolean updateUser(User user);

    boolean deleteUser(int id);
}
