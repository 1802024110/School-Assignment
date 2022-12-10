package com.example.videos.controller;

import com.example.videos.common.R;
import com.example.videos.note.AuthCheck;
import com.example.videos.service.CommentService;
import com.example.videos.service.imp.CommentServiceImp;
import com.example.videos.utils.RequestUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.*;
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
        // 获得ip
        String ip = RequestUtil.getIP(request);
        System.out.println(ip);
        Boolean result = commentService.sendComment(token, comment,video_id,parent_id,ip);
        return result?R.success("发送成功"):R.error("发送失败");
    }

    @DELETE
    @Path("delete/{id}")
    @AuthCheck
    public R<String> delete(@Context HttpServletRequest request,@PathParam("id") String id){
        String token = request.getHeader("Authorization");
        Boolean result = commentService.deleteComment(token,id);
        return result?R.success("删除成功"):R.error("删除失败");
    }


}
