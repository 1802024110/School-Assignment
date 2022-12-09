import com.example.videos.dao.UserDao;
import com.example.videos.dao.VideoDao;
import com.example.videos.dao.imp.UserDaoImp;
import com.example.videos.dao.imp.VideoDaoImp;
import com.example.videos.entity.Video;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class T1 {
    @Test
    public void test(){
        VideoDao videoDao = new VideoDaoImp();
        List<Video> videos = videoDao.getRandomVideos();
        System.out.println(videos);
    }
}
