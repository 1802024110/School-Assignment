package com.example.videos.controller;

import com.example.videos.common.R;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.HashMap;
import java.util.Map;

@Path("user")
public class UserController {

    @POST
    @Path("register")
    @Produces(MediaType.APPLICATION_JSON)
    public R<Map> hi(){
        Map<String, String> params = new HashMap();
        params.put("access_token","_bl_uid");
        params.put("expires_in","_bl_uid");
        params.put("refresh_token","_bl_uid");
        params.put("redirectUrl","_bl_uid");
        return R.success(params);
    }
}