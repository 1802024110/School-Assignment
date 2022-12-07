import com.example.videos.dao.UserDao;
import com.example.videos.dao.imp.UserDaoImp;
import org.junit.jupiter.api.Test;

import java.util.List;

public class T1 {
    private static final long EXPIRE_DATE=60000*60*2;
    //token秘钥
    private static final String TOKEN_SECRET = "ZCfasfhuaUUHufguGuwu2020BQWE";
    @Test
    public void test(){
        UserDao userDao = new UserDaoImp();
        List<Integer> user = userDao.getLikeVideosByUserId(1);
        System.out.println(user);
    }
}
