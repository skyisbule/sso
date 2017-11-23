package com.skyisbule.sso.Service;

import com.skyisbule.sso.Dao.LoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by skyisbule on 2017/11/
 * 用来处理登录的一系列问题
 */
@Service
public class LoginService {

    @Autowired
    private LoginDao dao;

    public boolean isTrueForTel(String tel,String passwd){
        String realPasswd = dao.getPasswdByTel(tel);
        if (realPasswd==null)
            return false;
        return realPasswd.equals(passwd);
    }

}
