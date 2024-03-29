package com.douk.muses.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.douk.muses.pojo.TInvitation;
import com.douk.muses.mapper.TInvitationMapper;
import com.douk.muses.pojo.or.UserInvitation;
import com.douk.muses.service.TInvitationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.douk.utils.result.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * <p>
 * 帖子 服务实现类
 * </p>
 *
 * @author douk
 * @since 2023-06-02
 */
@Service
public class TInvitationServiceImpl extends ServiceImpl<TInvitationMapper, TInvitation> implements TInvitationService {
    Date s = new Date();
    @Value("${files.upload.path}")
    private String basePath;

    @Override
    public List<TInvitation> getIIT(int i) {
        LambdaQueryWrapper<TInvitation> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByDesc(TInvitation::getInvitationId);
        wrapper.last("limit " + i);
        return baseMapper.selectList(wrapper);
    }

    @Override
    public List<UserInvitation> getUserInvitation(int x, int y) {
        List<UserInvitation> userInvitationList = baseMapper.getUserInvitationList(x, y);
        return userInvitationList;
    }

    @Override
    public List<UserInvitation> getHotUserInvitation(int x, int y) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, -7);
        s = calendar.getTime();
        s.setHours(0);
        s.setMinutes(0);
        s.setSeconds(0);
        List<UserInvitation> userInvitationList = baseMapper.getHotUserInvitation(s, x, y);
        return userInvitationList;
    }




    @Override
    public Map<String, Object> invitationContest(Integer invitationId) {
        Map<String, Object> map = baseMapper.invitationContest(invitationId);
        Map<String, Object> maps=new HashMap<>();
        maps.put("isAttention",0);
        maps.put("isGood",0);
        maps.put("isNoGood",0);
        maps.put("isCollect",0);
        maps.put("isBuy",0);
        map.put("relation",maps);
        return map;
    }
    @Override
    public Map<String, Object> invitationContestById(Integer userId, Integer invitation) {
        Map<String, Object> map = baseMapper.invitationContest(invitation);
        Map<String, Object> maps=baseMapper.relation(userId,invitation);
        if(null==maps){
            maps=new HashMap<>();
            maps.put("isAttention",0);
            maps.put("isGood",0);
            maps.put("isNoGood",0);
            maps.put("isCollect",0);
            maps.put("isBuy",0);
        }
        map.put("relation",maps);

        return map;
    }

    @Override
    public int insertByUid(Integer userId, Map<String, String> map) {
        TInvitation invitation = new TInvitation();
        invitation.setUId(userId);
        invitation.setTitle(map.get("title"));//标题
        invitation.setContent(map.get("content"));//内容
        invitation.setContent(map.get("price"));//价格
        invitation.setContent(map.get("partitions"));//分区
        invitation.setContent(map.get("private"));//私有
        invitation.setContent(map.get("tag"));//标签
        invitation.setIOrM(map.get("iorm"));//图片或视频链接

        return baseMapper.insert(invitation);
    }


    @Override
    public Result post(MultipartFile header) {
        File file = new File("");
        //判空
        if (!header.isEmpty()) {
            //getOriginalFilename上传文件的文件名 有后缀
            String originalFilename = header.getOriginalFilename();
            String substring = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            UUID uuid = UUID.randomUUID();
            file = new File(basePath + uuid + "." + substring);
            try {
                header.transferTo(file);
            } catch (IOException e) {
                return Result.fail("未上传成功");
            }
        }

        return Result.ok(file);

    }
}