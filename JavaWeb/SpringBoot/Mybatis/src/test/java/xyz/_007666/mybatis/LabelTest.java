package xyz._007666.mybatis;

import org.junit.Test;
import xyz._007666.mybatis.entity.User;
import xyz._007666.mybatis.mapper.LabelMapper;
import xyz._007666.mybatis.utils.SqlSessionUtils;

import java.util.Map;

public class LabelTest {
    private LabelMapper labelMapper;

    public LabelTest() {
        this.labelMapper = SqlSessionUtils.getMapper(LabelMapper.class);
    }

    @Test
    public void sqlTemplate(){
        User user = labelMapper.sqlTemplate();
        System.out.println(user.toString());
    }
    @Test
    public void singleParameterType(){
        User user = labelMapper.singleParameterType(2);
        System.out.println(user.toString());
    }

    @Test
    public void findByColumn(){
        User user = labelMapper.findByColumn("id","2");
        System.out.println(user.toString());
    }
    @Test
    public void myResult(){
        User user = labelMapper.myResultMap();
        System.out.println(user);
    }

    @Test
    public void selectUserAddress(){
        User user = labelMapper.selectUserAddress(2);
        System.out.println(user.toString());
    }
}
