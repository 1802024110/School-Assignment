package com.example.videos.service.imp;

import com.example.videos.dao.PublicDao;
import com.example.videos.dao.imp.PublicDaoImp;
import com.example.videos.service.PublicService;
import com.example.videos.utils.StringUtils;

public class PublicServiceImp implements PublicService {
    private final PublicDao publicDao = new PublicDaoImp();
    /**
     * @param code
     * @param email
     * @return
     */
    @Override
    public Boolean setCodeByEmail(String code, String email) {
        // 懒得再改了，借用一下方法
        String encryptCode = StringUtils.encryptionPasswd(code);
        Boolean result = publicDao.saveCodeByEmail(encryptCode, email);
        return result;
    }

    /**
     * @param code
     * @param email
     * @return
     */
    @Override
    public Boolean checkCodeByEmail(String code, String email) {
        String encryptCode = publicDao.getCodeByEmail(email);
        if (encryptCode == null || code.equals("")) {
            return false;
        }
        Boolean result = StringUtils.verifyPassword(code, encryptCode);
        return result;
    }
}
