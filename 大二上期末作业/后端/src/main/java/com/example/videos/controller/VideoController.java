package com.example.videos.controller;

import com.example.videos.common.R;
import com.example.videos.entity.Video;
import com.example.videos.note.AuthCheck;
import com.example.videos.service.VideoService;
import com.example.videos.service.imp.VideoServiceImp;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Path("video")
@Slf4j
@Produces(MediaType.APPLICATION_JSON)
public class VideoController {
    private final VideoService videoService = new VideoServiceImp();
    @GET
    @Path("info/{id}")
    @AuthCheck
    public R<Video> getVideoInfo(@PathParam("id") Integer videoId) {
        Video video = videoService.getVideoById(videoId);
        return R.success(video);
    }

    @GET
    @Path("search/{keyword}/{page}")
    @AuthCheck
    public R<List<Video>> getVideoByKey(@PathParam("keyword") String keyword, @PathParam("page") Integer page) {
         List<Video> videos = videoService.getVideoByKey(keyword,page);
        return R.success(videos);
    }
}
