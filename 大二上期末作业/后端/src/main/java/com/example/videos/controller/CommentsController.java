package com.example.videos.controller;

import com.example.videos.common.R;
import com.example.videos.note.AuthCheck;
import com.example.videos.service.CommentService;
import com.example.videos.service.imp.CommentServiceImp;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;

@Path("comments")
@Slf4j
@Produces(MediaType.APPLICATION_JSON)
public class CommentsController {
    CommentService commentService = new CommentServiceImp();
    @POST
    @Path("send")
    @AuthCheck
    public R<String> sendComment(
            @Context HttpServletRequest request,
            @FormParam("comment") String comment,
            @FormParam("video_id") String video_id,
            @FormParam("parent_id") long parent_id
    ){
        String token = request.getHeader("Authorization");
        Boolean result = commentService.sendComment(token, comment,video_id,parent_id);
        return result?R.success("发送成功"):R.error("发送失败");
    }
}
