package xyz._007666.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class  SqlSessionUtils {
    static private final String resource = "mybatis-config.xml";
    static private SqlSession sqlSession;

    static {
        try (InputStream inputStream = Resources.getResourceAsStream(resource)) {
            SqlSessionFactory sess = new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = sess.openSession(true);
        } catch (IOException e) {
            throw new RuntimeException("mybatis配置文件未成功识别" + e);
        }
    }

    static public <T> T getMapper(Class<T> clazz) {
        return sqlSession.getMapper(clazz);
    }
}
