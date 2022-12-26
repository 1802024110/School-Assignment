import com.example.videos.dao.*;
import com.example.videos.dao.imp.PublicDaoImp;
import org.junit.jupiter.api.Test;

public class T1 {
    @Test
    public void test(){
        PublicDao publicDao = new PublicDaoImp();
        //Boolean a = publicDao.saveCodeByEmail("23","dsfdsfs");
        //System.out.println(a);
        System.out.println(publicDao.getCodeByEmail("dsfdsf"));
    }
}
