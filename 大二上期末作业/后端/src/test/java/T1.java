import at.favre.lib.crypto.bcrypt.BCrypt;
import com.example.videos.dao.UserDao;
import com.example.videos.dao.imp.UserDaoImp;
import com.example.videos.entity.User;
import com.example.videos.service.UserService;
import com.example.videos.service.UserServiceImp;
import com.example.videos.utils.TimeUtil;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class T1 {
    @Test
    public void test(){
        System.out.println(TimeUtil.MillisecondsToDate(System.currentTimeMillis() + 60000 * 60 * 24));
    }
}
