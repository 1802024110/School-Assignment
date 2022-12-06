import at.favre.lib.crypto.bcrypt.BCrypt;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.videos.dao.UserDao;
import com.example.videos.dao.imp.UserDaoImp;
import com.example.videos.entity.User;
import com.example.videos.service.UserService;
import com.example.videos.service.UserServiceImp;
import com.example.videos.utils.TimeUtil;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class T1 {
    private static final long EXPIRE_DATE=60000*60*2;
    //token秘钥
    private static final String TOKEN_SECRET = "ZCfasfhuaUUHufguGuwu2020BQWE";
    @Test
    public void test(){
    }
}
