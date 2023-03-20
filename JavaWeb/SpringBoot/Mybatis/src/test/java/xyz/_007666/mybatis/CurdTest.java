package xyz._007666.mybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz._007666.mybatis.entity.User;
import xyz._007666.mybatis.mapper.CurdMapper;
import xyz._007666.mybatis.utils.SqlSessionUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CurdTest {
    private CurdMapper curdMapper;

    public CurdTest() {
        this.curdMapper = SqlSessionUtils.getMapper(CurdMapper.class);
    }

    @Test
    public void selectUserById() {
        User user = curdMapper.getUserById(1);
        System.out.println(user.toString());
    }

    @Test
    public void insertUser() {
        User user = new User();
        user.setGender("男");
        user.setPassword("123");
        user.setUsername("阿里巴巴");
        user.setPhone("12354");

        curdMapper.insertUser(user);
        System.out.println(user.getId());
    }

    @Test
    public void updateUserById() {
        User user = new User();
        user.setId(201);
        user.setUsername("阿里巴巴");
        boolean row = curdMapper.updateUser(user);
        System.out.println(row);
    }

    @Test
    public void deleteUserById() {
        Boolean deleted = curdMapper.deleteUser(5);
        System.out.println(deleted);
    }

}

