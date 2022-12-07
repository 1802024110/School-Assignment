package com.example.videos.service.imp;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.videos.dao.UserDao;
import com.example.videos.dao.VideoDao;
import com.example.videos.dao.imp.UserDaoImp;
import com.example.videos.dao.imp.VideoDaoImp;
import com.example.videos.entity.Video;
import com.example.videos.service.VideoService;
import com.example.videos.utils.TokenUtils;

import java.util.ArrayList;
import java.util.List;

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
    public List<Video> getVideoByKey(String keyword, Integer page) {
        List<Video> videos = videoDao.getVideoByKey(keyword, page);
        Integer count = videos.getVideoCountByKey(keyword);
        return null;
    }
}
