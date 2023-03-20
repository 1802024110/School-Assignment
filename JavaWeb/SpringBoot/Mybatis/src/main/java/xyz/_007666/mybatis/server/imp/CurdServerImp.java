package xyz._007666.mybatis.server.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import xyz._007666.mybatis.entity.User;
import xyz._007666.mybatis.mapper.CurdMapper;
import xyz._007666.mybatis.server.CurdServer;
import xyz._007666.mybatis.utils.SqlSessionUtils;

@Service
public class CurdServerImp implements CurdServer {
    private CurdMapper curdMapper;
    @Autowired
    CurdServerImp(SqlSessionUtils sqlSessionUtils){
        this.curdMapper = sqlSessionUtils.getMapper(CurdMapper.class);
    }
    public User getUserById(int id) {
        User user = curdMapper.getUserById(id);
        return user;
    }

    @Override
    public boolean saveUser( User user) {
        return curdMapper.insertUser(user);
    }

    @Override
    public boolean updateUser(User user) {
        return curdMapper.updateUser(user);
    }

    @Override
    public boolean deleteUser(int id) {
        return curdMapper.deleteUser(id);
    }
}