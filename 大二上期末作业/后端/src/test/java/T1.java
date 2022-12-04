import com.example.videos.utils.EmailUtils;
import org.junit.jupiter.api.Test;

public class T1 {
    @Test
    public void test(){
        EmailUtils.sendSimpleMessage("1802024110@qq.com","测试","132");
    }
}
