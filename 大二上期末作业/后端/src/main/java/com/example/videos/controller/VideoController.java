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
import java.util.Map;

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
    public R<Map<String,Object>> getVideoByKey(@PathParam("keyword") String keyword, @PathParam("page") Integer page) {
        Map<String,Object> videos = videoService.getVideoByKey(keyword,page);
        return R.success(videos);
    }

    @GET
    @Path("recommended/{page}")
    @AuthCheck
    public R<Map<String,Object>> getVideoRecommended(@Context HttpServletRequest request,@PathParam("page") Integer page){
        String token = request.getHeader("Authorization");
        Map<String,Object> videos = videoService.getVideoRecommended(token,page);
        return R.success(videos);
    }
}
