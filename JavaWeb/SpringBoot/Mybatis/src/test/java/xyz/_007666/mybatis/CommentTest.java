package xyz._007666.mybatis;

import org.junit.Test;
import xyz._007666.mybatis.entity.User;
import xyz._007666.mybatis.mapper.SelectMapper;
import xyz._007666.mybatis.utils.SqlSessionUtils;

public class CommentTest {
    private SelectMapper selectMapper;

    public CommentTest() {
        this.selectMapper = SqlSessionUtils.getMapper(SelectMapper.class);
    }

    @Test
    public void getUserComments(){
        User user = selectMapper.getUserComments(2);
        System.out.printf(user.toString());
    };
}
