package com.example.videos.service.imp;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.videos.dao.UserDao;
import com.example.videos.dao.VideoDao;
import com.example.videos.dao.imp.UserDaoImp;
import com.example.videos.dao.imp.VideoDaoImp;
import com.example.videos.entity.User;
import com.example.videos.entity.Video;
import com.example.videos.service.VideoService;
import com.example.videos.utils.TokenUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VideoServiceImp implements VideoService {
    private final UserDao userDao = new UserDaoImp();
    private final VideoDao videoDao = new VideoDaoImp();

    /**
     * @param videoId
     * @return
     */
    @Override
    public Video getVideoById(Integer videoId) {
        return videoDao.getVideoById(videoId);
    }

    /**
     * @param keyword
     * @param page
     * @return
     */
    @Override
    public Map<String, Object> getVideoByKey(String keyword, Integer page) {
        List<Video> videos = videoDao.getVideoByKey(keyword, page);
        Integer count = videoDao.getVideoCountByKey(keyword);
        Map<String, Object> reusetMap = new HashMap<String, Object>();
        reusetMap.put("data", videos);
        reusetMap.put("total", count);
        reusetMap.put("limit", count != 0 ? count / 10 : 0);
        return reusetMap;
    }

    /**
     * @param page
     * @return
     */
    @Override
    public Map<String, Object> getVideoRecommended(String token, Integer page) {
        DecodedJWT tokenJwt = TokenUtils.convert_token(token);
        String email = tokenJwt.getClaim("email").asString();
        // 获得当前用户的id
        Integer userId = userDao.getUserIdByEmail(email);
        // 获得用户喜欢的类型列表
        List<Integer> styles = videoDao.getUserLikeStyles(userId);
        // 获得类型列表的具体视频
        List<Video> videos = videoDao.getStyleVideos(styles, 0);
        videos.forEach(video -> {
            try {
                User user = videoDao.getUserByVideoID((int) video.getId());
                video.setAuthor(user.getPublicInfo());
            } catch (Exception e) {
                // 这里是视频没有上传者
                User user = new User();
                video.setAuthor(user.getPublicInfo());
            }
        });
        Integer count = videoDao.getVideoCountByStyles(styles);
        Map<String, Object> reusetMap = new HashMap<>();
        reusetMap.put("total", count);
        reusetMap.put("limit", count != 0 ? count / 10 - 1 : 0);
        reusetMap.put("data", videos);
        return reusetMap;
    }

    /**
     * @return
     */
    @Override
    public List<Video> getRandomVideos() {
        List<Video> videos = videoDao.getRandomVideos();
        videos.forEach(video -> {
            try {
                System.out.println("当前视频" + video.getId());
                User user = videoDao.getUserByVideoID((int) video.getId());
                video.setAuthor(user.getPublicInfo());
            } catch (Exception e) {
                // 这里是视频没有上传者
                User user = new User();
                video.setAuthor(user.getPublicInfo());
            }
        });
        return videos;
    }
}
