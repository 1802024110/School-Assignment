import com.example.videos.dao.CommentDao;
import com.example.videos.dao.UserDao;
import com.example.videos.dao.VideoDao;
import com.example.videos.dao.imp.CommentDaoImp;
import com.example.videos.dao.imp.UserDaoImp;
import com.example.videos.dao.imp.VideoDaoImp;
import com.example.videos.entity.Comment;
import com.example.videos.entity.Video;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class T1 {
    @Test
    public void test(){
        CommentDao commentDao = new CommentDaoImp();
        List<Comment> comments = commentDao.queryVideoComments(1,0);
        System.out.println(comments);
    }
}
