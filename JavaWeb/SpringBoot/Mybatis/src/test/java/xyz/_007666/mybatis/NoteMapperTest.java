package xyz._007666.mybatis;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xyz._007666.mybatis.entity.User;
import xyz._007666.mybatis.mapper.NoteMapper;
import xyz._007666.mybatis.utils.SqlSessionUtils;

import java.util.List;
@SpringBootTest
public class NoteMapperTest {
    private NoteMapper noteMapper;

    @Autowired
    public NoteMapperTest(SqlSessionUtils sqlSessionUtils) {
        this.noteMapper = sqlSessionUtils.getMapper(NoteMapper.class);
    }

    @Test
    public void selectNoteTest(){
        User user = noteMapper.getUserById(1);
        System.out.println(user.toString());
    }

    @Test
    public void getUserTest(){
        User user = noteMapper.getUserById(2);
        System.out.println(user.toString());
    }

    @Test
    public void getUserBySelectProvide(){
        List<User> users = noteMapper.getUsersByName("王");
        System.out.println(users.toString());
    }
}
