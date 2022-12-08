import com.example.videos.dao.UserDao;
import com.example.videos.dao.VideoDao;
import com.example.videos.dao.imp.UserDaoImp;
import com.example.videos.dao.imp.VideoDaoImp;
import com.example.videos.entity.Video;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class T1 {
    private static final long EXPIRE_DATE=60000*60*2;
    //token秘钥
    private static final String TOKEN_SECRET = "ZCfasfhuaUUHufguGuwu2020BQWE";
    @Test
    public void test(){
        VideoDao videoDao = new VideoDaoImp();
//        List<Video> videos = videoDao.getVideoByKey("视频",1);
//        System.out.println(videos);
//        List<Integer> videoStyles = videoDao.getUserLikeStyles(1);
//        System.out.println(videoStyles);
        List<Integer> videoStyles = Arrays.asList(1, 2, 3, 4, 5);
//
        List<Video> videos = videoDao.getStyleVideos(videoStyles,0);
        //System.out.println(videos);
        //
        //Integer count = videoDao.getVideoCountByStyles(videoStyles);
        //System.out.println(count);
    }
}
