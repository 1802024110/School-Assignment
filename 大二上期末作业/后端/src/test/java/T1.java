import com.example.videos.dao.UserDao;
import com.example.videos.dao.imp.UserDaoImp;
import com.example.videos.entity.User;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;

public class T1 {
    private UserDao userDaoImp = new UserDaoImp();
    @Test
    public void test(){
        User user = userDaoImp.getUserByToken("K5HF");
        System.out.println(user);
    }
}
