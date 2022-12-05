import com.example.videos.dao.UserDao;
import com.example.videos.dao.imp.UserDaoImp;
import com.example.videos.entity.User;
import org.junit.jupiter.api.Test;

public class T1 {
    @Test
    public void test(){
        UserDao userDao = new UserDaoImp();
        User   user = new User();
        user.setEmail("test@example.com");
        user.setPassword("sdfsdfdf");
        user.setUsername("测试6");
        user.setIp("127.0.0.1");
        userDao.insertUser(user);
    }
}
